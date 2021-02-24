
package OBJFrame;

public class Dm_khohang {
    private String Ma_khohang,Ten_khohang,Ma_hang;
    private int SL_tonkho;
    
    public Dm_khohang() {
        }
    
    public Dm_khohang(String Ma_khohang,String Ten_khohang,String Ma_hang,Integer SL_tonkho){
         this.Ma_khohang = Ma_khohang;
         this.Ten_khohang = Ten_khohang;
         this.Ma_hang = Ma_hang;
         this.SL_tonkho = SL_tonkho;

     }
     
    public String getMa_khohang() {
        return Ma_khohang;
    }
    public void setMa_khohang(String Ma_khohang) {
        this.Ma_khohang = Ma_khohang;
    }
    
        public String getTen_khohang() {
        return Ten_khohang;
    }
    public void setTen_khohang(String Ten_khohang) {
        this.Ten_khohang = Ten_khohang;
    }
    

    public String getMa_hang() {
        return Ma_hang;
    }
    public void setMa_hang(String Ma_hang) {
        this.Ma_hang = Ma_hang;
    }
    
    public Integer getSL_tonkho() {
        return SL_tonkho;
    }
    public void setSL_tonkho(Integer SL_tonkho) {
        this.SL_tonkho = SL_tonkho;
    }
}
