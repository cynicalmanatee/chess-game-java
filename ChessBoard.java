import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame implements ActionListener{
    static final char[][] setup = {
        {'r','n','b','q','k','b','n','r'},
        {'p','p','p','p','p','p','p','p'},
        {'\0','\0','\0','\0','\0','\0','\0','\0'},
        {'\0','\0','\0','\0','\0','\0','\0','\0'},
        {'\0','\0','\0','\0','\0','\0','\0','\0'},
        {'\0','\0','\0','\0','\0','\0','\0','\0'},
        {'p','p','p','p','p','p','p','p'},
        {'r','n','b','q','k','b','n','r'}
    };
    public void startGame(){
        System.out.println("game has started");
        initializeGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    private void initializeGUI(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        Color black = new Color(192,192,192);
        Color white = new Color(255,255,255);
        JButton tile;
        String tileDisplay;
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
				c.gridx = col;
				c.gridy = row;
                tile = new JButton();
                tile.setPreferredSize(new Dimension(100,100));
                tile.setFont(new Font("Times New", Font.PLAIN, 60));
                tile.putClientProperty("row", row);
                tile.putClientProperty("col", col);
                tile.setBackground((row+col)%2==1?black:white);
                tile.setOpaque(true);
                tile.addActionListener(this);
                add(tile, c);
            }
        }

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.startGame();
    }
}
