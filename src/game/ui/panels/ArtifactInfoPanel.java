package game.ui.panels;

import core.Main;
import game.artifacts.Artifact;
import game.effects.Effect;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Images;

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
    public void render(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.fillRect(x, y, Main.getScreenWidth(), (float) (Main.getScreenHeight() * 0.05));

        int currentX = x + padding;

        for (Artifact artifact : artifacts) {
            int artifactX = currentX;
            int artifactY = y + padding;
            int artifactWidth = artifact.getImage().getWidth();
            int artifactHeight = artifact.getImage().getHeight();

            // Draw the artifact image
            renderSingleArtifact(g, artifactX, artifactY, artifact);

            // Check for mouse hover
            int mouseX = gc.getInput().getMouseX();
            int mouseY = gc.getInput().getMouseY();
            if (mouseX >= artifactX && mouseX <= artifactX + artifactWidth &&
                    mouseY >= artifactY && mouseY <= artifactY + artifactHeight) {
                tooltip.render(g, mouseX, mouseY, artifact.getDescription());
            }

            currentX += artifactWidth + padding;
        }
    }
    public void renderSingleArtifact(Graphics g, int x, int y, Artifact artifact){
        g.drawImage(artifact.getImage(), x, y);
    }
}
