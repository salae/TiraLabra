package vertailu;

/**
 * Punamusta puu on tasapainotettu binäärinen hakupuu, jonka solmuissa on
 * tieto siitä, onko solmu punainen vai musta.
 * 
 * @author Anu
 */
public class PunamustaPuu extends BinHakupuu implements Puu{
    
//    private PmSolmu juuri;
    private PmSolmu nil;

    /**
     * Luo tyhjän punamustan puun
     */
    public PunamustaPuu() {
        this.nil = new PmSolmu(-1, false);
        this.setJuuri(this.nil);
    }

    @Override
    public PmSolmu hae(int avain) {
        PmSolmu x = (PmSolmu) this.getJuuri();  //etsintäkohta        
        while(x != this.nil && x.getAvain() != avain){
            if(avain < x.getAvain()) {
                x = (PmSolmu) x.getVasenLapsi();
            } else {
                x = (PmSolmu) x.getOikeaLapsi();
            }
        }
//        if(x == this.nil){ x = null;} //ohjelman yhtenäisen logiikan takia
        return x;
    }
    
    /**
     * @inheritDoc 
     * 
     * Pitää huolta siitä, että punamusta puu on riittävän tasapainoinen
     * lisäyksen jälkeen huolehtimalla solmujen oikeasta värityksestä ja 
     * tarvittavista kierroista.
     */
    public void lisaa(int avain) {
        PmSolmu uusi = new PmSolmu(avain, true);
        this.lisaaSolmu(uusi);
        uusi.setOikeaLapsi(this.nil);
        uusi.setVasenLapsi(this.nil);
        this.korjaaLisays(uusi);
    }
    
    /**
     * Lisää puuhun uuden punamustan puun solmun.
     * 
     * @param uusi lisättävä solmu
     */
     private void lisaaSolmu(PmSolmu uusi) {        
        PmSolmu p = this.nil;  //vanhempi
        PmSolmu x = (PmSolmu) this.getJuuri();  //etsintäkohta          
        while(x != this.nil){
            p = x;
            x = (PmSolmu)((uusi.getAvain() < x.getAvain()) ?  x.getVasenLapsi()
                 :  x.getOikeaLapsi());
        }
        uusi.setVanhempi(p);
        if(p == this.nil){
            this.setJuuri(uusi);
        }else if(uusi.getAvain() < p.getAvain()){
            p.setVasenLapsi(uusi);
        } else {
            p.setOikeaLapsi(uusi);
        } 
    }   

    /**
     * @inheritDoc 
     * 
     * Pitää huolta siitä, että punamusta puu on riittävän tasapainoinen
     * poiston jälkeen huolehtimalla solmujen oikeasta värityksestä ja 
     * tarvittavista kierroista.
     */
    public void poista(int avain) {
        PmSolmu pois = this.hae(avain);
        if(pois != nil){
            poistaSolmu(pois);
        }        
    }
    
    private void poistaSolmu(PmSolmu pois){
//         if (pois == nil || pois == null) {
//            return;
//        }       
        PmSolmu y = pois;
        PmSolmu x ;
        boolean yOrigVari = y.onkoPunainen();
        if(pois.getVasenLapsi() == this.nil || pois.getOikeaLapsi() == this.nil){
            x = (pois.getVasenLapsi() == this.nil) ? (PmSolmu) pois.getOikeaLapsi()
                    : (PmSolmu) pois.getVasenLapsi();
            this.vaihdaAlipuuta(pois, x);
        }else {  // 2 lasta
            y = (PmSolmu) this.haeMin(pois.getOikeaLapsi());
            yOrigVari = y.onkoPunainen();
            x = (PmSolmu) y.getOikeaLapsi();
            if(y.getVanhempi() == pois){
                x.setVanhempi(y);
            }else{
                this.vaihdaAlipuuta(y, x);
                y.setOikeaLapsi(pois.getOikeaLapsi());
                y.getOikeaLapsi().setVanhempi(y);
            }
            this.vaihdaAlipuuta(pois, y);
            y.setVasenLapsi(pois.getVasenLapsi());
            y.getVasenLapsi().setVanhempi(y);
            y.asetaVari(pois.onkoPunainen());
        }
        if(!yOrigVari){
            this.korjaaPoisto(x);
        }
    }
    
    @Override
    public Solmu haeMin(Solmu s){
        while(s.getVasenLapsi() != this.nil){
            s = s.getVasenLapsi();
        }        
        return s;
    } 
    
    @Override
    public void tyhjennaPuu(Solmu s) {
        this.setJuuri(nil);
    }
        
    /**
     * Vaihtaa yhden alipuun tilalle toisen.
     * 
     * @param eka vaihdettavan alipuun juuri
     * @param toka korvaavan alipuun juuri
     */
    private void vaihdaAlipuuta(PmSolmu eka, PmSolmu toka){
        if(eka.getVanhempi() == this.nil){
            this.setJuuri(toka);
        }else if(eka == eka.getVanhempi().getVasenLapsi()){
            eka.getVanhempi().setVasenLapsi(toka);
        }else {
            eka.getVanhempi().setOikeaLapsi(toka);
        }
//        if(toka != nil){
            toka.setVanhempi(eka.getVanhempi());
//        }        
    }    
    
    /**
     * Kierretään solmua vasemmalle.
     * 
     * @param x kierrettävä solmu
     */
    private void kiertoVasemmalle(PmSolmu x){
        PmSolmu o = (PmSolmu) x.getOikeaLapsi();
        x.setOikeaLapsi(o.getVasenLapsi());
        if(o.getVasenLapsi() != this.nil ){
            o.getVasenLapsi().setVanhempi(x);
        }
        this.vaihdaAlipuuta(x, o);
        o.setVasenLapsi(x);
        x.setVanhempi(o);
    }
    
    /**
     * Kierretään solmua oikealle.
     * 
     * @param x kierrettävä solmu
     */
    private void kiertoOikealle(PmSolmu x){
        PmSolmu y = (PmSolmu) x.getVasenLapsi();
        x.setVasenLapsi(y.getOikeaLapsi());
        if(y.getOikeaLapsi() != this.nil && y != this.nil){
            y.getOikeaLapsi().setVanhempi(x);
        }
        this.vaihdaAlipuuta(x, y);
        y.setOikeaLapsi(x);
        x.setVanhempi(y); 
    }

    /**
     * Korjataan puu, niin että se täyttää lisäyksen jälkeen
     * punamustalle puulle asetetut ehdot.
     * 
     * @param uusi lisätty solmu
     */
    private void korjaaLisays(PmSolmu uusi) {
        while(((PmSolmu)uusi.getVanhempi()).onkoPunainen()){
//            PmSolmu y = new PmSolmu(0,true);
            if(((PmSolmu)uusi.getVanhempi())== ((PmSolmu)uusi.getVanhempi()).getVanhempi().getVasenLapsi()){
                PmSolmu y = (PmSolmu)uusi.getVanhempi().getVanhempi().getOikeaLapsi();
                if(y.onkoPunainen()){
                    ((PmSolmu)uusi.getVanhempi()).asetaVari(false);
                    y.asetaVari(false);
                    ((PmSolmu)uusi.getVanhempi().getVanhempi()).asetaVari(true);
                    uusi = (PmSolmu)uusi.getVanhempi().getVanhempi();
                }else {
                    if(uusi == uusi.getVanhempi().getOikeaLapsi()){
                        uusi = (PmSolmu) uusi.getVanhempi();
                        this.kiertoVasemmalle(uusi);
                    }
                    ((PmSolmu)uusi.getVanhempi()).asetaVari(false);
                    ((PmSolmu)uusi.getVanhempi().getVanhempi()).asetaVari(true);
                    this.kiertoOikealle(((PmSolmu)uusi.getVanhempi().getVanhempi()));
                }                
            }else{
               PmSolmu y = (PmSolmu)uusi.getVanhempi().getVanhempi().getVasenLapsi();
                if(y.onkoPunainen()){
                    ((PmSolmu)uusi.getVanhempi()).asetaVari(false);
                    y.asetaVari(false);
                    ((PmSolmu)uusi.getVanhempi().getVanhempi()).asetaVari(true);
                    uusi = (PmSolmu)uusi.getVanhempi().getVanhempi();
                }else {
                    if(uusi == uusi.getVanhempi().getVasenLapsi()){
                        uusi = (PmSolmu) uusi.getVanhempi();
                        this.kiertoOikealle(uusi);
                    }
                    ((PmSolmu)uusi.getVanhempi()).asetaVari(false);
                    ((PmSolmu)uusi.getVanhempi().getVanhempi()).asetaVari(true);
                    this.kiertoVasemmalle(((PmSolmu)uusi.getVanhempi().getVanhempi()));  
                }
            }           
        }
        ((PmSolmu)this.getJuuri()).asetaVari(false);
    }
    /**
     * Korjataan puu, niin että se täyttää poiston jälkeen
     * punamustalle puulle asetetut ehdot.
     * 
     * @param x korjausta kaipaava solmu
     */
    private void korjaaPoisto(PmSolmu x) {
//        System.out.println("x tullessa korjaukseen: "+x);
        while(x != this.getJuuri() && !x.onkoPunainen()){
//            PmSolmu sisar = nil;
            if(x == x.getVanhempi().getVasenLapsi()){
                PmSolmu sisar = (PmSolmu) x.getVanhempi().getOikeaLapsi();
                if(sisar.onkoPunainen()){
                    sisar.asetaVari(false);
                    ((PmSolmu)sisar.getVanhempi()).asetaVari(true);
                    this.kiertoVasemmalle((PmSolmu) x.getVanhempi());
                    sisar = (PmSolmu) x.getVanhempi().getOikeaLapsi();
                }
//                if(sisar != nil){
                    if(!((PmSolmu)sisar.getVasenLapsi()).onkoPunainen() && !((PmSolmu)sisar.getOikeaLapsi()).onkoPunainen()){
                      sisar.asetaVari(true);
                      x = (PmSolmu) x.getVanhempi();
                      continue;
                    } else if (!((PmSolmu)sisar.getOikeaLapsi()).onkoPunainen()){
                        ((PmSolmu)sisar.getVasenLapsi()).asetaVari(false);
                        sisar.asetaVari(true);
                        this.kiertoOikealle(sisar);
                        sisar = (PmSolmu) x.getVanhempi().getOikeaLapsi();
                    }
                    sisar.asetaVari(((PmSolmu)x.getVanhempi()).onkoPunainen());
                    ((PmSolmu)x.getVanhempi()).asetaVari(false);
//                    System.out.println("x "+x);
//                    System.out.println("vanhempi "+x.getVanhempi());
//                    System.out.println("sisar " + sisar);
//                    System.out.println(sisar.getOikeaLapsi());
//                PmSolmu oSisar = (PmSolmu)sisar.getOikeaLapsi();
//                PmSolmu pöö = x;
//                if(sisar != nil){
                        ((PmSolmu)sisar.getOikeaLapsi()).asetaVari(false);                    
                        this.kiertoVasemmalle((PmSolmu) x.getVanhempi());
                        x = (PmSolmu) this.getJuuri();
//                     }                   
//                }                
                
            } else if(x == x.getVanhempi().getOikeaLapsi()){
                PmSolmu sisar = (PmSolmu) x.getVanhempi().getVasenLapsi();
                if(sisar.onkoPunainen()){
                    sisar.asetaVari(false);
                    ((PmSolmu)sisar.getVanhempi()).asetaVari(true);
                    this.kiertoOikealle((PmSolmu) x.getVanhempi());
                    sisar = (PmSolmu) x.getVanhempi().getVasenLapsi();
                }
//                if(sisar != nil){
                    if(!((PmSolmu)sisar.getVasenLapsi()).onkoPunainen() && 
                       !((PmSolmu)sisar.getOikeaLapsi()).onkoPunainen()){
                      sisar.asetaVari(true);
                      x = (PmSolmu) x.getVanhempi();
                      continue;
                    } else if (!((PmSolmu)sisar.getVasenLapsi()).onkoPunainen()){
                        ((PmSolmu)sisar.getOikeaLapsi()).asetaVari(false);
                        sisar.asetaVari(true);
                        this.kiertoVasemmalle(sisar);
                        sisar = (PmSolmu) x.getVanhempi().getVasenLapsi();
                    }
                    sisar.asetaVari(((PmSolmu)x.getVanhempi()).onkoPunainen());
                    ((PmSolmu)x.getVanhempi()).asetaVari(false);
                    ((PmSolmu)sisar.getVasenLapsi()).asetaVari(false);
//                }
                this.kiertoOikealle((PmSolmu) x.getVanhempi());
                x = (PmSolmu) this.getJuuri();               
            }
        }
        x.asetaVari(false);
    }


    @Override
    public void tulostaPuu(Solmu s) {
        if (s != nil) {
           tulostaPuu(s.getVasenLapsi());
           System.out.println(s.toString());
           tulostaPuu(s.getOikeaLapsi());
        }
    } 
    
}

