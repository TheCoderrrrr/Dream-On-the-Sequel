package game.ui;

import core.Main;
import game.artifacts.Artifact;
import game.effects.Effect;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Images;

import java.awt.*;
import java.util.ArrayList;

public class ArtifactInfoPanel extends Panel{
    private ArrayList<Effect> effects;
    private ArrayList<Artifact> artifacts = new ArrayList<>();
    private int padding = (int) (Main.getScreenWidth() * 0.01);
    public ArtifactInfoPanel(){
        tooltip = new Tooltip();
    }
    public void updateArtifacts(ArrayList<Artifact> artifacts){
        this.artifacts = artifacts;
    }
    public void render(Graphics g, int x, int y){
        g.setColor(Color.black);
        g.fillRect(x, y, Main.getScreenWidth(), Images.ENERGY0.getHeight());
        for(int i = 0; i < artifacts.size() - 1; i++){
            Artifact artifact = artifacts.get(i);
            renderSingleArtifact(g, x + i * artifact.getImage().getWidth() + padding, y, artifact);
        }
    }
    public void renderSingleArtifact(Graphics g, int x, int y, Artifact artifact){
        g.drawImage(artifact.getImage(), x, y);


    }
}
