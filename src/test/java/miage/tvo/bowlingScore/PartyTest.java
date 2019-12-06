package miage.tvo.bowlingScore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartyTest {

  @Test
  public void testCalculeScorePartieSansStrikeSansSpare(){
    // given : une partie de 10 jeux avec 6 quilles tombés dans chaque jeu
    Jeu leJeu = new Jeu(6,0);
    Party laPartie = new Party(leJeu);
    // when : on calcule le score
    Integer score = laPartie.calculeScore(); // Integer car il peut être null
    // then : on obtient un score de 60
    assertEquals("La calcule ne retourne pas la bonne score de la partie",Integer.valueOf(60),score);
  }

  @Test
  public void testCalculeScorePartieQueDesSpares(){
    // given: une partie de 10 jeux que des spares
    Jeu leJeu = new Jeu(5,5);
    Party laPartie = new Party(leJeu);
    // when: on calcule le score
    Integer score = laPartie.calculeScore();
    // then : on obtien un score de 150
    assertEquals("La calcule ne retourne pas la bonne score de la partie",Integer.valueOf(150),score);
  }

  @Test
  public void testCalculeScorePartieQueDesStrikes(){
    // given: une partie de 10 jeux que des strike
    Jeu leJeu = new Jeu(10,null);
    Party laPartie = new Party(leJeu);
    // when: on calcule le score
    Integer score = laPartie.calculeScore();
    // then : on obtien un score de 300
    assertEquals("La calcule ne retourne pas la bonne score de la partie",Integer.valueOf(300),score);
  }

  @Test
  public void testCalculeScorePartieMix(){
    // given : une partie de 10 jeux mix
    List<Jeu> jeux = new ArrayList<>();
    jeux.add(new Jeu(10,null));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(5,5));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(6,0));
    jeux.add(new Jeu(10,null));
    Party laPartie = new Party(jeux);
    // when : on calcule le score
    Integer score = laPartie.calculeScore();
    // then : on obtien un score de 104
    assertEquals("La calcule ne retourne pas la bonne score de la partie",Integer.valueOf(104),score);

  }
}