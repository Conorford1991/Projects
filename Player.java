
package zombiedice;

/**
 *
 * @author Conor
 */
public class Player {
   public String Name;
   public int ShotgunScore;
   public int BrainScore;
   
   void SetName(String Name){
       this.Name = Name;
   }
   void SetShotgunScore(int ShotgunScore){
       this.ShotgunScore = ShotgunScore;
   }
   void SetBrainScore(int BrainScore){
       this.BrainScore = BrainScore;
   }
   String GetName(){
       System.out.println("Name: "+Name);
       return Name;
   }
   int GetShotgunScore(){
       return ShotgunScore;
   }
   int GetBrainScore(){
       return BrainScore;
   }
}
