package miage.tvo.bowlingScore;

public class Jeu {
  private Integer lancer1;
  private Integer lancer2;


  public Jeu(Integer lancer1, Integer lancer2) {
    this.lancer1 = lancer1;
    this.lancer2 = lancer2;
  }


  public Integer getLancer1() {
    return lancer1;
  }

  public Integer getLancer2() {
    return lancer2;
  }

  public Integer nombredeQuillesTombes(){
    if (lancer2 != null){
      return lancer1 + lancer2;
    }
    else {
      return lancer1;
    }
  }

  public boolean isSpare(){
    return (lancer2 != null && (lancer1+lancer2 == 10));
  }

  public boolean isStrike(){
    return (lancer2 == null && lancer1 == 10);
  }
}
