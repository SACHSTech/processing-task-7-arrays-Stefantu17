import processing.core.PApplet;

public class Sketch extends PApplet {

  float[] circleY = new float[50];
  float[] snowfall = new float[50];
  float[] mousePositionsX = new float[25];
  float[] mousePositionsY = new float[25];
  int snowSpeed = 3;
  int num = 25;
  int index = 0;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    for (int i = 0; i < 50; i++) {
      circleY[i] = random(0, 400);
    }
    for (int i = 0; i < 50; i++) {
      snowfall[i] = 5;
    }
  }

  public void draw() {

    background(0);

    // Drawing falling snow
    for (int circleX = 0; circleX < 50; circleX++) {
      ellipse(circleX*8, circleY[circleX], 8, 8);
    }
  
    for (int i = 0; i < 50; i++) {
      circleY[i] += snowSpeed;
      if (circleY[i] >= 400) {
        circleY[i] = 0;
        snowfall[i] += 5;
      }
    }
    
    // Drawing snow pile
    for (int i = 0; i < 50; i++) {
      fill(255, 255, 255);
      rect(i*8, 400-snowfall[i], 8, 400);
    }

    // Trail
    noStroke();
    mousePositionsX[index] = mouseX;
    mousePositionsY[index] = mouseY;
    index = (index + 1) % num;
    for (int i = 0; i < 25; i++) {
      int pos = (index + i) % num;
      ellipse(mousePositionsX[pos], mousePositionsY[pos], i, i);
    }
  }

  public void keyPressed() {
    if (keyCode == DOWN) {
      snowSpeed = 1;
    }
    if (keyCode == UP) {
      snowSpeed = 5;
    }
  }

  public void keyReleased() {
    snowSpeed = 3;
  }
}