//thanks to lyndon_daniels for the basic code construct here ^_^
class orb {
  color R;
  color G;
  color B;
  float orbX;
  float orbY;
  float orbsize;

  orb(float temporbX, float temporbY, float tempOrbsizeX, float tempOrbsizeY, color colourR, color colourG, color colourB) {
     orbX = temporbX;
     orbY = temporbY;
     orbsize = tempOrbsizeX;
     orbsize = tempOrbsizeY;
     R = colourR;
     G = colourG;
     B = colourB;
   }

  void disp() {
    fill(R, G, B);
    ellipse(orbX, orbY, orbsize, orbsize);
   }
   
   void collide() {
     if  (sqrt(sq(playerX-orbX)+sq(playerY-orbY)) < (playersize+orbsize)/2) {
       if (playersize > orbsize) {
         println("Collision: player > orb");
         while (orbsize > 0.0) {
           playersize = playersize + orbsize;
           orbsize = 0.0;
           if (orbsize == 0.0) {
             break;
           }
         }
       }
     }
     if (sqrt(sq(playerX-orbX)+sq(playerY-orbY)) < (playersize+orbsize)/2) {
       if (playersize < orbsize) {
         println("Collision: player < orb");
         while (playersize > 0.0) {
           playersize = playersize - 5.0;
           orbsize = orbsize + 5.0;
           if (playersize <= 0.0) {
             break;
           }
         }
       }
     }
//     
} 
     
       
   float OrbVectX, OrbVectY;
   float OrbNormX, OrbNormY;
   float OrbSpeed = 3.8;

   void movement() {
       float OrbChaseVectorX = playerX - orbX; 
       float OrbChaseVectorY = playerY - orbY; 
       OrbChaseVectorX = OrbChaseVectorX * OrbSpeed;
       OrbChaseVectorY = OrbChaseVectorY * OrbSpeed;
       println("chase code: orb"); //prints a line to the debug console
       OrbNormX = norm(OrbChaseVectorX, 0.0, 800.0);
       OrbNormY = norm(OrbChaseVectorY, 0.0, 600.0);
       orbX = orbX - OrbNormX;
       orbY = orbY - OrbNormY;
       println("has run");
     }
         
}
