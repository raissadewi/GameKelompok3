package whack_a_mole;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vivobook
 */
public class Game extends JFrame{

    private static InputStream bis;
    
    private JPanel panel;
    JLabel[] holes = new JLabel[9];
    int[] board = new int[9];

    int score = 0;
    int timeLeft = 30;
    private int highscore = 0;
    
    JLabel lblScore;
    JLabel lblTimeLeft;
    private JLabel lblHighscore;

    JButton btnStart;
    Timer timer;
    
    private void loadHighscore(){
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/highscore.txt"));
            line = br.readLine();
            br.close();
        } catch (IOException e) {
            line = "";
        }

        if(line != ""){
            highscore = Integer.parseInt(line);
            lblHighscore.setText("Highscore: " + highscore);
        }
    }

    public void saveHighscore(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/highscore.txt", false)); //append - set to false
            bw.write("" + highscore);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error while saving highscore", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void gameOver(){
        btnStart.setEnabled(true);
        if(score > highscore){
            highscore = score;
            lblHighscore.setText("Highscore: " + highscore);
            JOptionPane.showMessageDialog(this, "Skor yang kamu dapatkan: " + score, "Kamu dapat skor tertinggi!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Skor yang kamu dapatkan: " + score, "Yuk main lagi!!", JOptionPane.INFORMATION_MESSAGE);
        }
        score = 0;
        timeLeft = 30;
        lblScore.setText("Score: 0");
        lblTimeLeft.setText("30");

        clearBoard();
        
        saveHighscore();
    }
     
    public void pressedButton(int id){
        int val = board[id];
        
        //if val is 1 = mole
        //if val is 0 = empty hole
        if(val==1){ 
            score++;
        }else{ //val==0
            score--;
        }

        lblScore.setText("Score: " + score); //update the score

        clearBoard();

        genRandMole();
    }
     
    public void initEvents(){
        for(int i = 0; i < holes.length; i++){
            holes[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    JLabel lbl = (JLabel)e.getSource();
                    var id = Integer.parseInt(lbl.getName());
                    pressedButton(id);
                }
            });
        }
        
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                clearBoard();
                genRandMole();
                timer.start();
            }
        });

        timer = new Timer(700, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(timeLeft == 0){
                    lblTimeLeft.setText("" + timeLeft);
                    timer.stop();
                    gameOver();
                }
                lblTimeLeft.setText("" + timeLeft);
                timeLeft--;
            }
        });    
    }
    
    private void initGUI(){
        //ukuran tampilan
        setTitle("Game Dino");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 451, 457);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/Cobain/dino-awal.png");
        setIconImage(icon);
        
        //warna background ijo tua
        JPanel contentPane = new JPanel();
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        //tulisan whack a mole
        JLabel lblTitle = new JLabel("GAME DINO");
        lblTitle.setForeground(new Color(51, 102, 0));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Georgia", Font.BOLD, 36));
        lblTitle.setBounds(10, 10, 420, 47);
        contentPane.add(lblTitle);
 
        //background ijo muda
        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 0));
        panel.setBounds(32, 105, 370, 280);
        panel.setLayout(null);
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                loadImage("../res/palu.png").getImage(),
                new Point(0,0),"custom cursor1"));
        contentPane.add(panel);

        holes[0] = new JLabel();
        holes[0].setName("0");
        holes[0].setBounds(10, 0, 132, 132);
        panel.add(holes[0]);

        holes[1] = new JLabel();
        holes[1].setName("1");
        holes[1].setBounds(135, 0, 132, 132);
        panel.add(holes[1]);

        holes[2] = new JLabel();
        holes[2].setName("2");
        holes[2].setBounds(260, 0, 132, 132);
        panel.add(holes[2]);

        holes[3] = new JLabel();
        holes[3].setName("3");
        holes[3].setBounds(10, 80, 132, 132);
        panel.add(holes[3]);

        holes[4] = new JLabel();
        holes[4].setName("4");
        holes[4].setBounds(135, 80, 132, 132);
        panel.add(holes[4]);

        holes[5] = new JLabel();
        holes[5].setName("5");
        holes[5].setBounds(260, 80, 132, 132);
        panel.add(holes[5]);

        holes[6] = new JLabel();
        holes[6].setName("6");
        holes[6].setBounds(10, 160, 132, 132);
        panel.add(holes[6]);

        holes[7] = new JLabel();
        holes[7].setName("7");
        holes[7].setBounds(135, 160, 132, 132);
        panel.add(holes[7]);

        holes[8] = new JLabel();
        holes[8].setName("8");
        holes[8].setBounds(260, 160, 132, 132);
        panel.add(holes[8]);

        lblScore = new JLabel("Score: 0");
        lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblScore.setFont(new Font("Cambria", Font.BOLD, 14));
        lblScore.setForeground(new Color(135, 206, 250));
        lblScore.setBounds(255, 75, 144, 33);
        contentPane.add(lblScore);

        lblTimeLeft = new JLabel("30");
        lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLeft.setForeground(new Color(0, 0, 0));
        lblTimeLeft.setFont(new Font("Cambria Math", Font.BOLD, 24));
        lblTimeLeft.setBounds(150, 70, 144, 33);
        contentPane.add(lblTimeLeft);

        lblHighscore = new JLabel("Highscore: 0");
        lblHighscore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHighscore.setForeground(new Color(220, 20, 60));
        lblHighscore.setFont(new Font("Cambria", Font.BOLD, 14));
        lblHighscore.setBounds(268, 58, 134, 33);
        contentPane.add(lblHighscore);

        btnStart = new JButton("Start");
        btnStart.setBackground(new Color(255, 160, 122));
        btnStart.setFont(new Font("Caveman", Font.BOLD, 15));
        btnStart.setBounds(31, 70, 75, 30);
        contentPane.add(btnStart);
        
        setContentPane(contentPane);
    }
    
    //tampilan hole
    public void clearBoard(){
    for(int i = 0; i < 9; i++){
            holes[i].setIcon(loadImage("../res/hole.png"));
            board[i] = 0;
        }
    }
    
    //tampilan dino
    public void genRandMole(){
        Random rnd = new Random(System.currentTimeMillis()); //seeding random with current time
        int moleID = rnd.nextInt(9);
        board[moleID] = 1;
        holes[moleID].setIcon(loadImage("../res/dino3.png"));
    }

    public ImageIcon loadImage(String path){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    
    public Game() {
        initGUI();
        clearBoard();
        initEvents();
        loadHighscore();
    }
    
}