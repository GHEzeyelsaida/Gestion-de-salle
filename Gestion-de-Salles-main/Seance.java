class Seance{

   String  codeM, cinEns, jour, date_deb, date_fin, numeroSal ;
   
   public Seance(){}

   public Seance(String jour, String date_deb, String numeroSal){
    
    this.jour=jour;
    this.date_deb=date_deb;
    this.numeroSal= numeroSal;
   }

   public Seance(String  codeM, String cinEns, String jour, String date_deb, String date_fin, String numeroSal){
    
    this.codeM=codeM; 
    this.cinEns=cinEns; 
    this.jour=jour;
    this.date_deb=date_deb;
    this.date_fin= date_fin;
    this.numeroSal= numeroSal;
   }


}