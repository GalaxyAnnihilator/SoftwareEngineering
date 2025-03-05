package TankBattleGame;

public class Projectile {
    int x, y, dx, dy, damage;
    boolean active;
    
    public Projectile(int x, int y, int dx, int dy, int damage) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.damage = damage;
        this.active = true;
    }
    
    public void move() {
        x += dx;
        y += dy;
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            active = false;
        }
    }
}
