/** ------------------------------------
 <  -  less-than
 >  -  more-than
 ----------------------------------- **/

int bg = 0;
int dotX = 200;
int dotY = 200;

void setup() {
  size(400, 400);
  smooth();
}


void draw () {
  //code for objcollenemy1:
  int xDist = enemyX - dotX;
  int yDist = enemyY - dotY;
  
  background(bg);
  fill(255, 0, 0);
  ellipse(dotX, dotY, 50, 50);
  wallcoll();
  enemy1();
  objcollenemy1();
}

void keyPressed() {
  if (key == CODED) { 

    if (keyCode == UP) {
      dotY-=4;
    } 
    else if (keyCode == DOWN) {
      dotY+=4;
    }
    else if (keyCode == LEFT) {
      dotX-=4;
    }
    else if (keyCode == RIGHT) {
      dotX+=4;
    }
  }
}

