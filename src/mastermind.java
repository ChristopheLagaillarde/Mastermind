/*/////////////////En tête////////////////////////////
 * Programme : Jeu du Mastermind
 *
 * Description : Ce programme génère le jeu du Mastermind
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 16/10/2021
 *        
 *///////////////////////////////////////////////////

// Déclaration des bibliotheques de fonctions...
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
class BoutonRond extends JButton {                      // On crée une classe qui hérite de jbutton et qui fait des boutons ronds qui représenterons les pions dans l'interface

	// Méthodes
	public BoutonRond(String label) {
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics modificationGraphique) {
		modificationGraphique.setColor(getBackground());
		modificationGraphique.fillOval(0, 0, getSize().width-1,getSize().height-1);
	}

	protected void paintBorder(Graphics modificationGraphique) {
		modificationGraphique.drawOval(0, 0, getSize().width-1,getSize().height-1);
	}
}
//////////////////Le Programme principal/////////////

//////////////////Début//////////////////////////////
public class mastermind {

	private JFrame fenetreJeu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mastermind fenetre = new mastermind();
					fenetre.fenetreJeu.setVisible(true);
				} catch (Exception problemeFenetre) {
					problemeFenetre.printStackTrace();
				}
			}
		});
	}

	public mastermind() {
		initialize();
	}

	private static final Border border = BorderFactory.createLoweredBevelBorder();   // Stylise le bouton
	int indiceNombreDEssaie = -50;                         // cette variable sert à compter le nombre d'essaie ET positionner le rang des pions/pions indice

	Color couleurGenerer(Double nombreAleatoire) {        // Permet à l'ordi de générer sa propre combinaison
		if(nombreAleatoire < 0.14) {
			return Color.RED;
		}
		if(nombreAleatoire < 0.28) {
			return Color.BLUE;
		}
		if(nombreAleatoire < 0.42) {
			return Color.YELLOW;
		}
		if(nombreAleatoire < 0.56) {
			return Color.GREEN;
		}
		if(nombreAleatoire < 0.7) {
			return Color.MAGENTA;
		}
		if(nombreAleatoire < 0.84) {
			return Color.GRAY;
		}
		else{
			return Color.CYAN;
		}
	}
	final Color couleurPion1Ordi = couleurGenerer(Math.random()); 
	final Color couleurPion2Ordi = couleurGenerer(Math.random());
	final Color couleurPion3Ordi = couleurGenerer(Math.random());
	final Color couleurPion4Ordi = couleurGenerer(Math.random());
	final Color couleurPion5Ordi = couleurGenerer(Math.random());

	void VerifieSiGagner(Color couleurPion1,Color couleurPion2,Color couleurPion3,Color couleurPion4,Color couleurPion5) {
		if(couleurPion1Ordi==couleurPion1 && couleurPion2Ordi== couleurPion2 && couleurPion3Ordi== couleurPion3 && couleurPion4Ordi== couleurPion4 && couleurPion5Ordi== couleurPion5 && indiceNombreDEssaie >= -200) { 
			JOptionPane.showMessageDialog(null,"Bravo !\nVotre nombre d'essaie a été de " + (indiceNombreDEssaie + 50)/-30);   // On recalcul le nombre d'essaie à partir de l'indice
		}
		if(couleurPion1Ordi==couleurPion1 && couleurPion2Ordi== couleurPion2 && couleurPion3Ordi== couleurPion3 && couleurPion4Ordi== couleurPion4 && couleurPion5Ordi== couleurPion5 && (indiceNombreDEssaie < -200 && indiceNombreDEssaie >= -350)) {
			JOptionPane.showMessageDialog(null,"Correct !\nVotre nombre d'essaie a été de " + (indiceNombreDEssaie + 50)/-30);
		}
		if(couleurPion1Ordi==couleurPion1 && couleurPion2Ordi== couleurPion2 && couleurPion3Ordi== couleurPion3 && couleurPion4Ordi== couleurPion4 && couleurPion5Ordi== couleurPion5 && indiceNombreDEssaie < -350) {
			JOptionPane.showMessageDialog(null,"Décevant \nVotre nombre d'essaie a été de " + (indiceNombreDEssaie + 50)/-30);
		}
	}
	private void initialize() {
		fenetreJeu = new JFrame("Mastermind");
		fenetreJeu.setBounds(100, 100, 265, 725);
		fenetreJeu.getContentPane().setBackground(new Color(139,69,19));
		fenetreJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreJeu.getContentPane().setLayout(null);

		class Pion{

			// Attributs
			int click;             //Permet de gérer le changement de couleur
			BoutonRond boutonPion;
			Color couleurActuel;
			int numeroPion;

			//Méthodes
			Pion(int positionX,int positionY,Color couleurActuel,int numeroPion) {
				this.couleurActuel = couleurActuel;
				this.boutonPion = new BoutonRond("");
				this.boutonPion.setBounds(positionX, positionY, 28, 23);
				this.boutonPion.setBorder(border);
				this.boutonPion.setBackground(this.couleurActuel);
				fenetreJeu.getContentPane().add(this.boutonPion);
				this.click = 0;
				this.numeroPion = numeroPion;
			}

			void changerCouleur() {
				if(this.click == 0) {
					this.boutonPion.setBackground(Color.RED);
					this.couleurActuel = Color.RED;
				}
				if(this.click == 1) {
					this.boutonPion.setBackground(Color.BLUE);
					this.couleurActuel = Color.BLUE;

				}
				if(this.click == 2) {
					this.boutonPion.setBackground(Color.YELLOW);
					this.couleurActuel = Color.YELLOW;

				}
				if(this.click == 3) {
					this.boutonPion.setBackground(Color.GREEN);
					this.couleurActuel = Color.GREEN;
				}
				if(this.click == 4) {
					this.boutonPion.setBackground(Color.MAGENTA);
					this.couleurActuel = Color.MAGENTA;

				}
				if(this.click == 5) {
					this.boutonPion.setBackground(Color.GRAY);
					this.couleurActuel = Color.GRAY;

				}
				if(this.click == 6) {
					this.boutonPion.setBackground(Color.CYAN);
					this.couleurActuel = Color.CYAN;
					this.click = -1;
				}
				this.click +=1;
			}

			void SauvegarderEssaie(int positionRange, int nombreDEssaie, Pion pion1, Pion pion2, Pion pion3, Pion pion4, Pion pion5) { 
				Pion pion1Sauvegarde = new Pion(10,positionRange + nombreDEssaie,pion1.couleurActuel,1);
				pion1Sauvegarde.boutonPion.doClick();                                                     // Compense le bug qui ne montre le pion que si il est on hover
				Pion pion2Sauvegarde = new Pion(50,positionRange + nombreDEssaie,pion2.couleurActuel,2);
				pion2Sauvegarde.boutonPion.doClick();
				Pion pion3Sauvegarde = new Pion(90,positionRange + nombreDEssaie,pion3.couleurActuel,3);
				pion3Sauvegarde.boutonPion.doClick();
				Pion pion4Sauvegarde = new Pion(130,positionRange + nombreDEssaie,pion4.couleurActuel,4);
				pion4Sauvegarde.boutonPion.doClick();
				Pion pion5Sauvegarde = new Pion(170,positionRange + nombreDEssaie,pion5.couleurActuel,5);
				pion5Sauvegarde.boutonPion.doClick();
			}
		}

		Pion pion1 = new Pion(10,602,Color.RED,1);           //Tout les pions commence en étant rouge c'est une convention arbitraire
		Pion pion2 = new Pion(50,602,Color.RED,2);
		Pion pion3 = new Pion(90,602,Color.RED,3);
		Pion pion4 = new Pion(130,602,Color.RED,4);
		Pion pion5 = new Pion(170,602,Color.RED,5);

		class PremierPionBlanc	{                           //Cette  classe permet de passer en parametre d'une methode les attributs boolean désigné ET les modifier 
			                                               // Autrement Java ne les modifies pas car il les passe par valeur
			//Attributs
			boolean estLePremierIndicePionBlancPourPion1Ordi;
			boolean estLePremierIndicePionBlancPourPion2Ordi;
			boolean estLePremierIndicePionBlancPourPion3Ordi;
			boolean estLePremierIndicePionBlancPourPion4Ordi;
			boolean estLePremierIndicePionBlancPourPion5Ordi;

			//Méthode
			PremierPionBlanc(){
				this.estLePremierIndicePionBlancPourPion1Ordi = true;
				this.estLePremierIndicePionBlancPourPion2Ordi = true;
				this.estLePremierIndicePionBlancPourPion3Ordi = true;
				this.estLePremierIndicePionBlancPourPion4Ordi = true;
				this.estLePremierIndicePionBlancPourPion5Ordi = true;
			}

			void setValeurInitial(){
				this.estLePremierIndicePionBlancPourPion1Ordi = true;
				this.estLePremierIndicePionBlancPourPion2Ordi = true;
				this.estLePremierIndicePionBlancPourPion3Ordi = true;
				this.estLePremierIndicePionBlancPourPion4Ordi = true;
				this.estLePremierIndicePionBlancPourPion5Ordi = true;
			}
		}
		PremierPionBlanc monPremierPionBlanc = new PremierPionBlanc();

		class IndicePion{

			//Attributs
			BoutonRond boutonIndicePion;
			Color couleurIndiceActuel;

			//Méthodes
			IndicePion(){
				this.boutonIndicePion = new BoutonRond("");
				this.couleurIndiceActuel = new Color(0,0,0,0);
			}
			
			IndicePion(Pion pionConcerne, Color couleurPion1Ordi,Color couleurPion2Ordi,Color couleurPion3Ordi,Color couleurPion4Ordi,Color couleurPion5Ordi, int positionX, int positionY, PremierPionBlanc monPremierPionBlanc){
				this.boutonIndicePion = new BoutonRond("");
				this.boutonIndicePion.setBounds(positionX, positionY, 9, 10);
				this.boutonIndicePion.setVisible(false);

				if(pionConcerne.couleurActuel == couleurPion1Ordi && monPremierPionBlanc.estLePremierIndicePionBlancPourPion1Ordi == true ) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
					monPremierPionBlanc.estLePremierIndicePionBlancPourPion1Ordi = false;
				}
				if(pionConcerne.couleurActuel == couleurPion2Ordi && monPremierPionBlanc.estLePremierIndicePionBlancPourPion2Ordi == true) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
					monPremierPionBlanc.estLePremierIndicePionBlancPourPion2Ordi = false;
				}
				if(pionConcerne.couleurActuel == couleurPion3Ordi && monPremierPionBlanc.estLePremierIndicePionBlancPourPion3Ordi == true) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
					monPremierPionBlanc.estLePremierIndicePionBlancPourPion3Ordi = false;
				}
				if(pionConcerne.couleurActuel == couleurPion4Ordi && monPremierPionBlanc.estLePremierIndicePionBlancPourPion4Ordi == true) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
					monPremierPionBlanc.estLePremierIndicePionBlancPourPion4Ordi = false;
				}
				if(pionConcerne.couleurActuel == couleurPion5Ordi && monPremierPionBlanc.estLePremierIndicePionBlancPourPion5Ordi == true) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
					monPremierPionBlanc.estLePremierIndicePionBlancPourPion5Ordi = false;
				}
				if((pionConcerne.couleurActuel == couleurPion1Ordi) && pionConcerne.numeroPion == 1) {
					this.couleurIndiceActuel = Color.BLACK;
					this.boutonIndicePion.setVisible(true);
				}
				if((pionConcerne.couleurActuel == couleurPion2Ordi) && pionConcerne.numeroPion == 2) {
					this.couleurIndiceActuel = Color.BLACK;
					this.boutonIndicePion.setVisible(true);
				}
				if((pionConcerne.couleurActuel == couleurPion3Ordi) && pionConcerne.numeroPion == 3) {
					this.couleurIndiceActuel = Color.BLACK;
					this.boutonIndicePion.setVisible(true);
				}
				if((pionConcerne.couleurActuel == couleurPion4Ordi) && pionConcerne.numeroPion == 4) {
					this.couleurIndiceActuel = Color.BLACK;
					this.boutonIndicePion.setVisible(true);
				}
				if((pionConcerne.couleurActuel == couleurPion5Ordi) && pionConcerne.numeroPion == 5) {
					this.couleurIndiceActuel = Color.BLACK;
					this.boutonIndicePion.setVisible(true);
				}
				this.boutonIndicePion.setBackground(this.couleurIndiceActuel);
				fenetreJeu.getContentPane().add(this.boutonIndicePion);
				this.boutonIndicePion.doClick();
			}

			@SuppressWarnings("unused")
			void donneIndice(int indiceNombreDEssaie){
			    IndicePion indicePion1 = new IndicePion(pion1,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,215, 613 + indiceNombreDEssaie,monPremierPionBlanc);
				IndicePion indicePion2 = new IndicePion(pion2,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,235, 613 + indiceNombreDEssaie,monPremierPionBlanc);
				IndicePion indicePion3 = new IndicePion(pion3,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,235, 601 + indiceNombreDEssaie,monPremierPionBlanc);
				IndicePion indicePion4 = new IndicePion(pion4,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,215, 601 + indiceNombreDEssaie,monPremierPionBlanc);
				IndicePion indicePion5 = new IndicePion(pion5,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,225, 608 + indiceNombreDEssaie,monPremierPionBlanc);
			}
		}
		IndicePion indiceVide = new IndicePion(); // Permet d'utiliser la procédure donneIndice plus tard

		System.out.println("Les couleurs solution sont dans l'ordre:");
		System.out.println(couleurPion1Ordi);     // Code à supprimer une fois que le jeu est terminé, ces lignes permetent de tester le jeu plus facilement
		System.out.println(couleurPion2Ordi);
		System.out.println(couleurPion3Ordi);
		System.out.println(couleurPion4Ordi);
		System.out.println(couleurPion5Ordi); 

		pion1.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				pion1.changerCouleur();
			}
		});

		pion2.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				pion2.changerCouleur();
			}
		});

		pion3.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				pion3.changerCouleur();
			}
		});

		pion4.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				pion4.changerCouleur();
			}
		});

		pion5.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				pion5.changerCouleur();
			}
		});

		JButton boutonEssayer = new JButton("Éssayer");
		boutonEssayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickSouris) {
				indiceNombreDEssaie -= 30;                  // On soustrait -30 pour gérer le hauteur sur l'interface de chaque essaie
				VerifieSiGagner(pion1.couleurActuel,pion2.couleurActuel,pion3.couleurActuel,pion4.couleurActuel,pion5.couleurActuel);
				pion1.SauvegarderEssaie(600,indiceNombreDEssaie, pion1, pion2, pion3, pion4, pion5);
				indiceVide.donneIndice(indiceNombreDEssaie);
				monPremierPionBlanc.setValeurInitial();
			}
		});
		boutonEssayer.setBounds(76, 645, 89, 23);
		fenetreJeu.getContentPane().add(boutonEssayer);
	}
}
//////////////////Fin//////////////////////////////