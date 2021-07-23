package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.MusicaDAO;
import Musicas.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JSlider;

public class Principal extends JFrame {
	public static PlayerSpotify player = new PlayerSpotify();
	public JProgressBar progressoMusica;
	private JPanel contentPane;
	ImageIcon logoI = new ImageIcon(getClass().getClassLoader().getResource("logomark2.png"));
	ImageIcon icone = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
	ImageIcon btnPlay = new ImageIcon(getClass().getClassLoader().getResource("playButton.png"));
	ImageIcon bordaLogo = new ImageIcon(getClass().getClassLoader().getResource("bordaicon.png"));
	NumberFormat formatter = new DecimalFormat("00");
	JLabel lbTempoTotal, lbTempoAtual;
	public boolean pausado = false;
	public boolean play = false;
	public Musica musica;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("Mark Music");
		
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("iconeP.png")));
		setBounds(550, 150, 800, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 25));
		panel_1.setBounds(187, 28, 583, 408);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("<html>100<br><br>50<br><br>0</html>");
		lblNewLabel_2.setForeground(new Color(4, 182, 56));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(738, 498, 44, 95);
		contentPane.add(lblNewLabel_2);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nomeMsc = new JLabel("");
		nomeMsc.setFont(new Font("Century Gothic", Font.BOLD, 15));
		nomeMsc.setHorizontalAlignment(SwingConstants.CENTER);
		nomeMsc.setForeground(new Color(4, 182, 56));
		nomeMsc.setBounds(360, 459, 231, 22);
		contentPane.add(nomeMsc);
		
		
		
		JLabel logo = new JLabel(logoI);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(250, 95, 442, 276);
		getContentPane().add(logo);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(10,10,10));
		panel.setBounds(0, 0, 175, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setBounds(0, 135, 175, 51);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(4, 182, 56));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(4, 182, 56));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		btnNewButton.setBackground(new Color(25, 25, 25));
		btnNewButton.setBounds(-13, 215, 201, 32);
		btnNewButton.setFocusable(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MUSICAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(4, 182, 56));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		btnNewButton_1.setBackground(new Color(25, 25, 25));
		btnNewButton_1.setBounds(-13, 271, 201, 32);
		btnNewButton_1.setFocusable(false);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DONATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "PIX: 21 983440206");
			}
		});
		btnNewButton_2.setForeground(new Color(4, 182, 56));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		btnNewButton_2.setBackground(new Color(25, 25, 25));
		btnNewButton_2.setBounds(-13, 327, 201, 32);
		btnNewButton_2.setFocusable(false);
		panel.add(btnNewButton_2);
		
		JLabel icon = new JLabel(icone);
		icon.setBounds(24, 13, 124, 119);
		panel.add(icon);
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSair.setForeground(new Color(4, 182, 56));
		btnSair.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		btnSair.setFocusable(false);
		btnSair.setBackground(new Color(25, 25, 25));
		btnSair.setBounds(-13, 527, 201, 32);
		panel.add(btnSair);
		
		JButton btnPlay = new JButton("");
		btnPlay.setBorder(null);
		btnPlay.setIcon(new ImageIcon(getClass().getClassLoader().getResource("playbutton.png")));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(play==false) {
					if(pausado) {
						player.resume();
					}
					else {
						player.play(musica.getDiretorio());
						fazerBarraProgresso();
					}
					pausado = false;
					play = true;
				}
			}
		});
		btnPlay.setBounds(462, 525, 32, 32);
		contentPane.add(btnPlay);
		
		JButton btnPause = new JButton("");
		btnPause.setBorder(null);
		btnPause.setIcon(new ImageIcon(getClass().getClassLoader().getResource("pausebutton.jpg")));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.pause();
				pausado = true;
				play = false;
			
			}
		});
		btnPause.setBounds(418, 523, 35, 35);
		contentPane.add(btnPause);
		
		JButton btnStop = new JButton("");
		btnStop.setBorder(null);
		btnStop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("stopbutton.png")));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.stop();
				play = false;
			}
		});
		btnStop.setBounds(506, 525, 32, 32);
		contentPane.add(btnStop);
		
		JButton msc1 = new JButton("");
		msc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 4:00 de tempo
					musica = MusicaDAO.buscar(new Musica("O Pai Ta On", "Costa Gold", "/Musicas/OPaiTaOn.mp3", 4, 0));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc1.setHorizontalTextPosition(SwingConstants.CENTER);
		msc1.setBackground(new Color(25, 25, 25));
		msc1.setFocusable(false);
		msc1.setBorder(null);
		msc1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("CostaGold_OPaiTaOn.jpg")));
		msc1.setBounds(12, 13, 178, 100);
		panel_1.add(msc1);
		
		JButton msc2 = new JButton("");
		msc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:03 de tempo
					musica = MusicaDAO.buscar(new Musica("Vida Louca", "MC Poze", "/Musicas/VidaLouca.mp3", 3, 3));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc2.setHorizontalTextPosition(SwingConstants.CENTER);
		msc2.setFocusable(false);
		msc2.setBorder(null);
		msc2.setBackground(new Color(25, 25, 25));
		msc2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Poze_VidaLouca.jpg")));
		msc2.setBounds(202, 13, 178, 100);
		panel_1.add(msc2);
		
		JButton msc3 = new JButton("");
		msc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:22 de tempo
					musica = MusicaDAO.buscar(new Musica("F*F*M", "Filipe Ret", "/Musicas/F_F_M_.mp3", 3, 22));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc3.setHorizontalTextPosition(SwingConstants.CENTER);
		msc3.setFocusable(false);
		msc3.setBorder(null);
		msc3.setBackground(new Color(25, 25, 25));
		msc3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ret_FFM.jpg")));
		msc3.setBounds(392, 13, 178, 100);
		panel_1.add(msc3);
		
		JButton msc4 = new JButton("");
		msc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:27 de tempo
					musica = MusicaDAO.buscar(new Musica("War", "Filipe Ret", "/Musicas/War.mp3", 3, 27));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc4.setHorizontalTextPosition(SwingConstants.CENTER);
		msc4.setFocusable(false);
		msc4.setBorder(null);
		msc4.setBackground(new Color(25, 25, 25));
		msc4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ret_WAR.jpg")));
		msc4.setBounds(12, 157, 178, 100);
		panel_1.add(msc4);
		
		JButton msc5 = new JButton("");
		msc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 2:36 de tempo
					musica = MusicaDAO.buscar(new Musica("Aonde Eu Sou Cria", "Borges", "/Musicas/AondeSouCria.mp3", 2, 36));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc5.setHorizontalTextPosition(SwingConstants.CENTER);
		msc5.setFocusable(false);
		msc5.setBorder(null);
		msc5.setBackground(new Color(25, 25, 25));
		msc5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("AondeEuSouCria.jpg")));
		msc5.setBounds(202, 157, 178, 100);
		panel_1.add(msc5);
		
		JButton msc6 = new JButton("");
		msc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:56 de tempo
					musica = MusicaDAO.buscar(new Musica("Anota a Placa", "TZ da Coronel", "/Musicas/anota_placa.mp3", 3, 56));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc6.setHorizontalTextPosition(SwingConstants.CENTER);
		msc6.setFocusable(false);
		msc6.setBorder(null);
		msc6.setBackground(new Color(25, 25, 25));
		msc6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("AnotaAPlaca.jpg")));
		msc6.setBounds(393, 157, 178, 100);
		panel_1.add(msc6);
		
		JButton msc7 = new JButton("");
		msc7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:16 de tempo
					musica = MusicaDAO.buscar(new Musica("Nota de 200", "Bruxo", "/Musicas/Nota200.mp3", 3, 16));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc7.setHorizontalTextPosition(SwingConstants.CENTER);
		msc7.setFocusable(false);
		msc7.setBorder(null);
		msc7.setBackground(new Color(25, 25, 25));
		msc7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Nota200_Bruxo.jpg")));
		msc7.setBounds(12, 297, 178, 100);
		panel_1.add(msc7);
		
		JButton msc8 = new JButton("");
		msc8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 4:08 de tempo
					musica = MusicaDAO.buscar(new Musica("Ciclone", "Costa Gold", "/Musicas/Ciclone.mp3", 4, 8));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc8.setHorizontalTextPosition(SwingConstants.CENTER);
		msc8.setFocusable(false);
		msc8.setBorder(null);
		msc8.setBackground(new Color(25, 25, 25));
		msc8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Ciclone_CG.jpg")));
		msc8.setBounds(202, 297, 178, 100);
		panel_1.add(msc8);
		
		JButton msc9 = new JButton("");
		msc9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStop.doClick();
				try {
					//referencia: nome da musica, nome do artista, diretório da musica, min, seg
					// a musica tem 3:50 de tempo
					musica = MusicaDAO.buscar(new Musica("Sodoma e Gomorra", "Borges", "/Musicas/SodomaeGomorra.mp3", 3, 50));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nomeMsc.setText(musica.getArtista() + " - " + musica.getNome());
				btnPlay.doClick();
			}
		});
		msc9.setHorizontalTextPosition(SwingConstants.CENTER);
		msc9.setFocusable(false);
		msc9.setBorder(null);
		msc9.setBackground(new Color(25, 25, 25));
		msc9.setIcon(new ImageIcon(getClass().getClassLoader().getResource("SodomaGomorra.jpg")));
		msc9.setBounds(393, 297, 178, 100);
		panel_1.add(msc9);
		
		progressoMusica = new JProgressBar();
		progressoMusica.setForeground(new Color(4, 182, 56));
		progressoMusica.setBounds(360, 498, 231, 14);
		contentPane.add(progressoMusica);
		
		lbTempoAtual = new JLabel("");
		lbTempoAtual.setForeground(new Color(4, 182, 56));
		lbTempoAtual.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbTempoAtual.setVerticalAlignment(SwingConstants.BOTTOM);
		lbTempoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lbTempoAtual.setBounds(303, 498, 56, 16);
		contentPane.add(lbTempoAtual);
		
		lbTempoTotal = new JLabel("");
		lbTempoTotal.setForeground(new Color(4, 182, 56));
		lbTempoTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lbTempoTotal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbTempoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbTempoTotal.setBounds(591, 498, 68, 16);
		contentPane.add(lbTempoTotal);
		
		JSlider slider = new JSlider();
		slider.setForeground(new Color(4, 182, 56));
		slider.setBackground(new Color(25, 25, 25));
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(712, 493, 35, 110);
		contentPane.add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Volume");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(4, 182, 56));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(690, 459, 80, 32);
		contentPane.add(lblNewLabel_1);
		
		
	}
	
	public void fazerBarraProgresso() {

        new Thread() {
            @Override
            public void run() {
            	int sec=0;
                long start;
                long elapsed = 0;
                progressoMusica.setMaximum(musica.getTempoSec());
                lbTempoTotal.setText(musica.getTempoMin());
                start = System.currentTimeMillis();

                while ((((int) elapsed / 1000) < musica.getTempoSec()) && play) {

                    try {

                        elapsed = (System.currentTimeMillis() - start)-sec;

                        progressoMusica.setValue(((int) elapsed) / 1000);
                        if ((((int) elapsed) / 1000) < 60) {
                            lbTempoAtual.setText("0:" + formatter.format((((int) elapsed) / 1000)) + "");
                        } else {
                            lbTempoAtual.setText((((int) elapsed) / 60000) + ":" + formatter.format((((int) elapsed) / 1000) - (((int) elapsed) / 60000)*60));
                        }
                        //sleep(100);
                        while (pausado) {
                        	sleep(1000);
                        	sec+= 1000;
                        }
                    }
                    catch (InterruptedException ie) {
                    }
                }
                progressoMusica.setValue(0);
                lbTempoAtual.setText("0:00");
                player.stop();
            }
        }.start();

    }
}
