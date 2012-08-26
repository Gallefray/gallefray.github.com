// ellipse(x, y, width, height);
float playerX = 400.0;
float playerY = 300.0;
float playersize = 50.0;

void playerellipse() {
  fill(0, 0, 255);
  ellipse(playerX, playerY, playersize, playersize);
}

// movement
void playermove() {
  if (keyPressed) { 
    // up / North
    if (key == 'e') {
      playerY-=5.0;
    } 
    // down / South
    else if (key == 'd') {
      playerY+=5.0;
    }
    // left / West
    else if (key == 's') {
      playerX-=5.0;
    }
    // right / East
    else if (key == 'f') {
      playerX+=5.0;
    }
    // top left / North West
    else if (key == 'w') {
      playerY-=5.0; playerX-=5.0;
    }
    // bottom left / South West
    else if (key == 'z') {
      playerY+=5.0; playerX-=5.0;
    }
    //top right / North East
    else if (key == 'r') {
      playerY-=5.0; playerX+=5.0;
    }
    // bottom right / South East 
    else if (key == 'v') {
      playerY+=5.0; playerX+=5.0;
    }
  }
}
