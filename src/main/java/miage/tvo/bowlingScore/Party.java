package miage.tvo.bowlingScore;

import java.util.ArrayList;
import java.util.List;

public class Party {
  private List<Jeu> jeux = new ArrayList<>();

  // constructor
  public Party(Jeu jeu){
    for(int i = 0; i < 10; i++){
      jeux.add(jeu);
    }
    if(jeux.get(9).isSpare()){
      jeux.add(jeu);
    }
    if(jeux.get(9).isStrike()){
      jeux.add(jeu);
      if(jeux.get(10).isStrike()){
        jeux.add(jeu);
      }
    }
  }

  // constructor pour un Liste de jeux donnée
  public Party(List<Jeu> jeux){
    this.jeux = jeux;
    if(jeux.get(9).isSpare()){
      jeux.add(jeux.get(0));
    }
    if(jeux.get(9).isStrike()){
      jeux.add(jeux.get(0));
      if(jeux.get(10).isStrike()){
        jeux.add(jeux.get(0));
      }
    }
  }

  public Integer calculeScore() {
    Integer score = 0;
    for(int i = 0; i < 10; i++){
      Jeu jeuCourant = jeux.get(i);
      score += jeuCourant.nombredeQuillesTombes();
      if (jeuCourant.isSpare()){
        score += jeux.get(i+1).getLancer1();
      }
      if (jeuCourant.isStrike()){
        score += jeux.get(i+1).getLancer1();
        if(jeux.get(i+1).isStrike()){
          score += jeux.get(i+2).getLancer1();
        }else{
          score += jeux.get(i+1).getLancer2();
        }
      }
    }
    return score;
  }
}
