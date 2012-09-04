/** ------------------------------------
 <  -  less-than
 >  -  more-than
 ----------------------------------- **/

void wallcoll() {
  if (dotX-25 <= 0) {
    dotX+=12;
  }
  else if (dotX+25 >= 400) {
    dotX-=12;
  }
  else if (dotY-25 <= 0) {
    dotY+=12;
  }
  else if (dotY+25 >= 400) {
    dotY-=12;
  } 
  // -------------------------------------------------------------
  // Repeats with enemy1
  if (enemyX-25 <= 0) {
    enemyX+=12;
  }
  else if (enemyX+25 >= 400) {
    enemyX-=12;
  }
  else if (enemyY-25 <= 0) {
    enemyY+=12;
  }
  else if (enemyY+25 >= 400) {
    enemyY-=12;
  }
}

//void objcollenemy1() {
//  /** O -> O **/
//  if (dotX+25 >= enemyX-25 && (dotY == enemyY)) {
//    enemyX+=4;
//    println("enemyX " + enemyX);
//  }
//  // But why is the following statement true when the one above is? is it to do with the Y co-ordinates?
//  else if (dotX-25 <= enemyX+25 && (dotY == enemyY+4)) {
////    enemyX-=4;
//    bg = 255;
//    println("enemyX " + enemyX);
//  }
//}

void objcollenemy1() {
  /** Thanks to http://forum.processing.org/user/benja for the solution to the problem **/

  // minumum distance
  int minDist = 50;

  // total distance 
  int xDist = enemyX - dotX;
  int yDist = enemyY - dotY;


  if (dotX > enemyX - enemysize/2 && dotX < enemyX+enemysize/2) { //(abs(xDist) < minDist && dotY == enemyY) {
    if (xDist >= 0) {
      enemyX += minDist - xDist;
      
    }
    else {
      enemyX -= minDist + xDist;
      
    }
  }
  if (dotY > enemyY-enemysize/2 && dotY < enemyY+enemysize/2) { //(abs(yDist) < minDist && dotX == enemyX) {
    if (yDist >= 0) {
      enemyY += minDist - yDist; 
    }
    else {
      enemyY -= minDist + yDist;
      
    }
  }
} 


