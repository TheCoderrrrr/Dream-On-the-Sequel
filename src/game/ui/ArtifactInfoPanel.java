package game.ui;

import game.artifacts.Artifact;
import game.effects.Effect;

import java.awt.*;
import java.util.ArrayList;

public class ArtifactInfoPanel extends Panel{
    private ArrayList<Effect> effects;
    private Artifact artifact;
    public ArtifactInfoPanel(Artifact artifact){
        tooltip = new Tooltip();
        this.artifact = artifact;
        if(this.artifact.getEffects() != null){
            effects = this.artifact.getEffects();
        }else{
            effects = new ArrayList<>();
            System.out.println("null");
        }
    }
    public void render(Graphics g, int x, int y){

    }
}
