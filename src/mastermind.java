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
class BoutonRond extends JButton {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mastermind fenetre = new mastermind();
					fenetre.fenetreJeu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * Create the application.
	 */

	public mastermind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private static final Border border = BorderFactory.createLoweredBevelBorder();
    int indiceNombreDEssaie = -50;

    Color couleurGenerer(Double nombreAleatoire) {
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
	Color couleurPion1Ordi = couleurGenerer(Math.random()); 
	Color couleurPion2Ordi = couleurGenerer(Math.random());
	Color couleurPion3Ordi = couleurGenerer(Math.random());
	Color couleurPion4Ordi = couleurGenerer(Math.random());
	Color couleurPion5Ordi = couleurGenerer(Math.random());
    
    
	void VerifieSiGagner(Color couleurPion1,Color couleurPion2,Color couleurPion3,Color couleurPion4,Color couleurPion5) {
    	if(couleurPion1Ordi==couleurPion1 && couleurPion2Ordi== couleurPion2 && couleurPion3Ordi== couleurPion3 && couleurPion4Ordi== couleurPion4 && couleurPion5Ordi== couleurPion5 && indiceNombreDEssaie >= -200) {
			JOptionPane.showMessageDialog(null,"Bravo !\nVotre nombre d'essaie a été de " + (indiceNombreDEssaie + 50)/-30);
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
			int click;
			BoutonRond boutonPion;
			Color couleurActuel;
			int numeroPion;

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
				pion1Sauvegarde.boutonPion.doClick();
				Pion pion2Sauvegarde = new Pion(50,positionRange + nombreDEssaie,pion2.couleurActuel,2);
				pion2Sauvegarde.boutonPion.doClick();
				Pion pion3Sauvegarde = new Pion(90,positionRange + nombreDEssaie,pion3.couleurActuel,3);
				pion3Sauvegarde.boutonPion.doClick();
				Pion pion4Sauvegarde = new Pion(130,positionRange + nombreDEssaie,pion4.couleurActuel,4);
				pion4Sauvegarde.boutonPion.setBackground(pion4.couleurActuel);
				pion4Sauvegarde.boutonPion.doClick();
				Pion pion5Sauvegarde = new Pion(170,positionRange + nombreDEssaie,pion5.couleurActuel,5);
				pion5Sauvegarde.boutonPion.doClick();
			}
		}
		
		Pion pion1 = new Pion(10,602,Color.RED,1);
		Pion pion2 = new Pion(50,602,Color.RED,2);
		Pion pion3 = new Pion(90,602,Color.RED,3);
		Pion pion4 = new Pion(130,602,Color.RED,4);
		Pion pion5 = new Pion(170,602,Color.RED,5);
		
		class IndicePion{
			BoutonRond boutonIndicePion;
			Color couleurIndiceActuel;
			
			IndicePion(){
				this.boutonIndicePion = new BoutonRond("");
				this.couleurIndiceActuel = new Color(0,0,0,0);
			}
			IndicePion(Pion pionConcerne, Color couleurPion1Ordi,Color couleurPion2Ordi,Color couleurPion3Ordi,Color couleurPion4Ordi,Color couleurPion5Ordi, int positionX, int positionY){
				this.couleurIndiceActuel = new Color(0,0,0,0);
				this.boutonIndicePion = new BoutonRond("");
				this.boutonIndicePion.setBounds(positionX, positionY, 9, 10);

				this.boutonIndicePion.setVisible(false);
				
				if(pionConcerne.couleurActuel == couleurPion1Ordi) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
				}
				if(pionConcerne.couleurActuel == couleurPion2Ordi) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
				}
				if(pionConcerne.couleurActuel == couleurPion3Ordi) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
				}
				if(pionConcerne.couleurActuel == couleurPion4Ordi) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
				}
				if(pionConcerne.couleurActuel == couleurPion5Ordi) {
					this.couleurIndiceActuel = Color.WHITE;
					this.boutonIndicePion.setVisible(true);
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
				IndicePion indicePion1 = new IndicePion(pion1,couleurPion1Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,215, 613 + indiceNombreDEssaie);
				IndicePion indicePion2 = new IndicePion(pion2,couleurPion2Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,235, 613 + indiceNombreDEssaie);
				IndicePion indicePion3 = new IndicePion(pion3,couleurPion3Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,235, 601 + indiceNombreDEssaie);
				IndicePion indicePion4 = new IndicePion(pion4,couleurPion4Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,215, 601 + indiceNombreDEssaie);
				IndicePion indicePion5 = new IndicePion(pion5,couleurPion5Ordi,couleurPion2Ordi,couleurPion3Ordi,couleurPion4Ordi,couleurPion5Ordi,225, 608 + indiceNombreDEssaie);
			}
		}
		
		IndicePion indiceVide = new IndicePion();
	    System.out.println(couleurPion1Ordi);
	    System.out.println(couleurPion2Ordi);
	    System.out.println(couleurPion3Ordi);
	    System.out.println(couleurPion4Ordi);
	    System.out.println(couleurPion5Ordi); 

		pion1.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pion1.changerCouleur();
			}
		});

		pion2.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pion2.changerCouleur();
			}
		});

		pion3.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pion3.changerCouleur();
			}
		});

		pion4.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pion4.changerCouleur();
			}
		});

		pion5.boutonPion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pion5.changerCouleur();
			}
		});
		;

		JButton boutonEssayer = new JButton("Éssayer");
		boutonEssayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				indiceNombreDEssaie -= 30;
				VerifieSiGagner(pion1.couleurActuel,pion2.couleurActuel,pion3.couleurActuel,pion4.couleurActuel,pion5.couleurActuel);
				pion1.SauvegarderEssaie(600,indiceNombreDEssaie, pion1, pion2, pion3, pion4, pion5);
				indiceVide.donneIndice(indiceNombreDEssaie);
			}
		});
		boutonEssayer.setBounds(76, 645, 89, 23);
		fenetreJeu.getContentPane().add(boutonEssayer);

	}

}
//////////////////Fin//////////////////////////////