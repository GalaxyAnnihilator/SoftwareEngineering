package TankBattleGame;

import java.awt.*;

class Tank {
    int x, y, hp, armor, damage;
    Color color;
    
    public Tank(int x, int y, int hp, int armor, int damage, Color color) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.armor = armor;
        this.damage = damage;
        this.color = color;
    }
    
    public void move(int dx, int dy) {
        x = Math.max(0, Math.min(7, x + dx));
        y = Math.max(0, Math.min(7, y + dy));
    }

    public void takeDamage(int dmg) {
        int actualDamage = Math.max(0, dmg - armor);
        hp -= actualDamage;
    }
}
