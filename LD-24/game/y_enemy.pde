// ellipse(x, y, width, height);

float enemyY = 100.0;
float enemyX = 100.0;
float enemysize = 150.0;
float enemyspeed = 5.0;

void enemyellipse() {
  fill(255, 0, 0);
  ellipse(enemyX, enemyY, enemysize, enemysize);
}

float vectX, vectY;
float normX, normY;

void chase() {
  //thanks to SteelRaven7 nd others, for the help, and the basic code construct ^_^
  float Xchasevector = playerX - enemyX; 
  float Ychasevector = playerY - enemyY; 
  Xchasevector = Xchasevector * enemyspeed;
  Ychasevector = Ychasevector * enemyspeed;
  println("chase code"); //prints a line to the debug console
  normX = norm(Xchasevector, 0.0, 800.0);
  normY = norm(Ychasevector, 0.0, 600.0);
  enemyX = enemyX + normX;
  enemyY = enemyY + normY;
  println("has run"); 
}
