
package zombiedice;

/**
 *
 * @author Conor
 */
public class DiceRoll {
    public int dice1;
    public int dice2;
    public int dice3;
    public int dice1side;
    public int dice2side;
    public int dice3side;
    
    public int DiceOneRoll(){
        // Red = 1, Yellow = 2, Green = 3
        dice1 = (int)(Math.random()*3+1);
        System.out.println("Dice one: "+dice1);
        return dice1;
    }
    public int DiceTwoRoll(){
        // Red = 1, Yellow = 2, Green = 3
        dice2 = (int)(Math.random()*3+1);
        System.out.println("Dice two: "+dice2);
        return dice2;
    }
    public int DiceThreeRoll(){
        // Red = 1, Yellow = 2, Green = 3
        dice3 = (int)(Math.random()*3+1);
        System.out.println("Dice three: "+dice3);
        return dice3;
    }
    public int DiceOneSide(){
        dice1side = (int)(Math.random()*6+1);
        System.out.println("Dice side one: "+dice1side);
        return dice1side;
    }
    public int DiceTwoSide(){
        dice2side = (int)(Math.random()*6+1);
        System.out.println("Dice side two: "+dice2side);
        return dice2side;
    }
    public int DiceThreeSide(){
        dice3side = (int)(Math.random()*6+1);
        System.out.println("Dice side three: "+dice3side);
        return dice3side;
    }
}
