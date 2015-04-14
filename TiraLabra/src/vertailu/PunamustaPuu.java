package vertailu;

/**
 * Punamusta puu on tasapainotettu binäärinen hakupuu, jonka solmuissa on
 * tieto siitä, onko solmu punainen vai musta.
 * 
 * @author Anu
 */
public class PunamustaPuu extends BinHakupuu implements Puu{
    
    private PmSolmu juuri;

    /**
     * Luo tyhjän punamustan puun
     */
    public PunamustaPuu() {
        this.juuri = null;
    }

//    @Override
//    public void lisaa(int avain) {
//
//        
//    }

    @Override
    public void poista(int avain) {
//        this.pmPuu.remove(new Solmu(avain));
    }
    
    private void kiertoVasemmalle(PmSolmu x){
        PmSolmu y = (PmSolmu) x.getOikeaLapsi();
        x.setOikeaLapsi(y.getVasenLapsi());
        if(y.getVasenLapsi() != null){
            y.getVasenLapsi().setVanhempi(x);
        }
        y.setVanhempi(x.getVanhempi());
        if(x.getVanhempi() == null){
            this.setJuuri(y);
        }else if(x == x.getVanhempi().getVasenLapsi()){
            x.getVanhempi().setVasenLapsi(y);
        }else {
            x.getVanhempi().setOikeaLapsi(y);
        }
        y.setVasenLapsi(x);
        x.setVanhempi(y);
    }
    
    private void kiertoOikealle(PmSolmu x){
        PmSolmu y = (PmSolmu) x.getVasenLapsi();
        x.setVasenLapsi(y.getOikeaLapsi());
        if(y.getOikeaLapsi() != null){
            y.getOikeaLapsi().setVanhempi(x);
        }
        y.setVanhempi(x.getVanhempi());
        if(x.getVanhempi() == null){
            this.setJuuri(y);
        }else if(x == x.getVanhempi().getOikeaLapsi()){
            x.getVanhempi().setOikeaLapsi(y);
        }else {
            x.getVanhempi().setVasenLapsi(y);
        }
        y.setOikeaLapsi(x);
        x.setVanhempi(y); 
    }

    
}

