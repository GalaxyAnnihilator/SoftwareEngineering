package TankBattleGame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;


public class TankBattleGame extends JPanel {
    Tank player1 = new Tank(0, 0, 100, 10, 20, Color.BLUE);
    Tank player2 = new Tank(7, 7, 100, 10, 20, Color.RED);
    ArrayList<Projectile> projectiles = new ArrayList<>();
    boolean gameOver = false;
    
    public TankBattleGame() {
        setPreferredSize(new Dimension(1000, 1000));
        setBackground(Color.WHITE);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) return;
                
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> player1.move(0, -1);
                    case KeyEvent.VK_A -> player1.move(-1, 0);
                    case KeyEvent.VK_S -> player1.move(0, 1);
                    case KeyEvent.VK_D -> player1.move(1, 0);
                    case KeyEvent.VK_UP -> player2.move(0, -1);
                    case KeyEvent.VK_LEFT -> player2.move(-1, 0);
                    case KeyEvent.VK_DOWN -> player2.move(0, 1);
                    case KeyEvent.VK_RIGHT -> player2.move(1, 0);
                    case KeyEvent.VK_SPACE -> projectiles.add(new Projectile(player1.x, player1.y, 1, 0, player1.damage));
                    case KeyEvent.VK_ENTER -> projectiles.add(new Projectile(player2.x, player2.y, -1, 0, player2.damage));
                }
                repaint();
            }
        });
        setFocusable(true);
        new Timer(100, e -> updateGame()).start();
    }
    
    private void updateGame() {
        if (gameOver) return;
        
        projectiles.forEach(Projectile::move);
        checkCollisions();
        projectiles.removeIf(p -> !p.active);
        
        if (player1.hp <= 0 || player2.hp <= 0) {
            gameOver = true;
        }
        
        repaint();
    }
    
    private void checkCollisions() {
        for (Projectile p : projectiles) {
            if (p.active && p.x == player1.x && p.y == player1.y) {
                player1.takeDamage(p.damage);
                p.active = false;
            }
            if (p.active && p.x == player2.x && p.y == player2.y) {
                player2.takeDamage(p.damage);
                p.active = false;
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = getWidth() / 8;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
        
        drawTank(g, player1, cellSize);
        drawTank(g, player2, cellSize);
        drawProjectiles(g, cellSize);
        drawHUD(g);
        
        if (gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Game Over!", 150, 200);
        }
    }
    
    private void drawTank(Graphics g, Tank tank, int cellSize) {
        g.setColor(tank.color);
        g.fillOval(tank.x * cellSize, tank.y * cellSize, cellSize, cellSize);
    }
    
    private void drawProjectiles(Graphics g, int cellSize) {
        g.setColor(Color.BLACK);
        for (Projectile p : projectiles) {
            g.fillRect(p.x * cellSize + cellSize / 3, p.y * cellSize + cellSize / 3, cellSize / 3, cellSize / 3);
        }
    }
    
    private void drawHUD(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Player 1 HP: " + player1.hp, 10, 20);
        g.drawString("Player 2 HP: " + player2.hp, 280, 20);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Battle");
        TankBattleGame game = new TankBattleGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
