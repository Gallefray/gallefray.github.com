float playerX = 400.0;
float playerY = 300.0;
float playersize = 60.0;

void playerellipse() {
  fill(0, 0, 255);
  ellipse(playerX, playerY, playersize, playersize);
}

// movement
float playerspeed = 7.5;
void playermove() {
  if (keyPressed) { 
    // up / North
    if (key == 'e') {
      playerY-=playerspeed;
    } 
    // down / South
    else if (key == 'd') {
      playerY+=playerspeed;
    }
    // left / West
    else if (key == 's') {
      playerX-=playerspeed;
    }
    // right / East
    else if (key == 'f') {
      playerX+=playerspeed;
    }
    // top left / North West
    else if (key == 'w') {
      playerY-=playerspeed; playerX-=playerspeed;
    }
    // bottom left / South West
    else if (key == 'z') {
      playerY+=playerspeed; playerX-=playerspeed;
    }
    //top right / North East
    else if (key == 'r') {
      playerY-=playerspeed; playerX+=playerspeed;
    }
    // bottom right / South East 
    else if (key == 'v') {
      playerY+=playerspeed; playerX+=playerspeed;
    }
  }
}
