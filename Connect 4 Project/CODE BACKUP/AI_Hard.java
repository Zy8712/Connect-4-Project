
public class AI_Hard {
  public static int hard =0;
  public static int hard_column = WinCon.hard_column;
  boolean turn = Connect4Gui.turn;
  public static boolean checkhard = false;
  public AI_Hard()
  {
    //WinCon();
    //Minmax and Alphabeta Pruning
    //Minmax: covering both the cases where players take alternate moves and those where they make simultaneous moves, 
    //it has also been extended to more complex games and to general decision-making in the presence of uncertainty.
    //Alphabeta Pruning: seeks to decrease the number of nodes that are evaluated by the minimax algorithm in its search 
    //tree. It is an adversarial search algorithm used commonly for machine playing of two-player games 
    //It stops completely evaluating a move when at least one possibility has been found that proves the move to be worse 
    //than a previously examined move. Such moves need not be evaluated further. When applied to a standard minimax tree, 
    //it returns the same move as minimax would, but prunes away branches that cannot possibly influence the final decision
    
    
//    public int evaluateBoard(Board b){
//      
//        int blanks = 0;
//        int k=0, moreMoves=0;
//        for(int i=5;i>=0;--i){
//            for(int j=0;j<=6;++j){
//                
//                if(board[i][j]==0 || board[i][j]==2) continue; 
//                
//                if(j<=3){ 
//                    for(k=1;k<4;++k){
//                        if(board[i][j+k]==1)++;
//                        else if(board[i][j+k]==2){blanks = 0;break;}
//                        else blanks++;
//                    }
//                     
//                    moreMoves = 0; 
//                    if(blanks>0) 
//                        for(int c=1;c<4;++c){
//                            int column = j+c;
//                            for(int m=i; m<= 5;m++){
//                             if(board[m][column]==0)moreMoves++;
//                                else break;
//                            } 
//                        } 
//                    
//                    if(moreMoves!=0) score += calculateScore(, moreMoves);
//                    =1;   
//                    blanks = 0;
//                } 
//                
//                if(i>=3){
//                    for(k=1;k<4;++k){
//                        if(board[i-k][j]==1)++;
//                        else if(board[i-k][j]==2){=0;break;} 
//                    } 
//                    moreMoves = 0; 
//                    
//                    if(>0){
//                        int column = j;
//                        for(int m=i-k+1; m<=i-1;m++){
//                         if(board[m][column]==0)moreMoves++;
//                            else break;
//                        }  
//                    }
//                    if(moreMoves!=0) score += calculateScore(, moreMoves);
//                    =1;  
//                    blanks = 0;
//                }
//                 
//                if(j>=3){
//                    for(k=1;k<4;++k){
//                        if(board[i][j-k]==1)++;
//                        else if(board[i][j-k]==2){=0; blanks=0;break;}
//                        else blanks++;
//                    }
//                    moreMoves=0;
//                    if(blanks>0) 
//                        for(int c=1;c<4;++c){
//                            int column = j- c;
//                            for(int m=i; m<= 5;m++){
//                             if(board[m][column]==0)moreMoves++;
//                                else break;
//                            } 
//                        } 
//                    
//                    if(moreMoves!=0) score += calculateScore(, moreMoves);
//                    =1; 
//                    blanks = 0;
//                }
//                 
//                if(j<=3 && i>=3){
//                    for(k=1;k<4;++k){
//                        if(board[i-k][j+k]==1)++;
//                        else if(board[i-k][j+k]==2){=0;blanks=0;break;}
//                        else blanks++;                        
//                    }
//                    moreMoves=0;
//                    if(blanks>0){
//                        for(int c=1;c<4;++c){
//                            int column = j+c, row = i-c;
//                            for(int m=row;m<=5;++m){
//                                if(board[m][column]==0)moreMoves++;
//                                else if(board[m][column]==1);
//                                else break;
//                            }
//                        } 
//                        if(moreMoves!=0) score += calculateScore(, moreMoves);
//                        =1;
//                        blanks = 0;
//                    }
//                }
//                 
//                if(i>=3 && j>=3){
//                    for(k=1;k<4;++k){
//                        if(board[i-k][j-k]==1)++;
//                        else if(board[i-k][j-k]==2){=0;blanks=0;break;}
//                        else blanks++;                        
//                    }
//                    moreMoves=0;
//                    if(blanks>0){
//                        for(int c=1;c<4;++c){
//                            int column = j-c, row = i-c;
//                            for(int m=row;m<=5;++m){
//                                if(board[m][column]==0)moreMoves++;
//                                else if(board[m][column]==1);
//                                else break;
//                            }
//                        } 
//                        if(moreMoves!=0) score += calculateScore(, moreMoves);
//                        =1;
//                        blanks = 0;
//                    }
//                } 
//            }
//        }
//        return score;
//    } 
//    
//    public int minimax(int depth, int turn, int alpha, int beta){
//        
//        if(beta<=alpha){if(turn == 1) return Integer.MAX_VALUE; else return Integer.MIN_VALUE; }
//        int gameResult = gameResult(b);
//        
//        if(gameResult==1)return Integer.MAX_VALUE/2;
//        else if(gameResult==2)return Integer.MIN_VALUE/2;
//        else if(gameResult==0)return 0; 
//        
//        if(depth==maxDepth)return evaluateBoard(b);
//        
//        int maxScore=Integer.MIN_VALUE, minScore = Integer.MAX_VALUE;
//                
//        for(int j=0;j<=6;++j){
//            
//            int currentScore = 0;
//            
//            if(!b.isLegalMove(j)) continue; 
//            
//            if(turn==1){
//                    b.placeMove(j, 1);
//                    currentScore = minimax(depth+1, 2, alpha, beta);
//                    
//                    if(depth==0){
//                        System.out.println("Score for location "+j+" = "+currentScore);
//                        if(currentScore > maxScore)nextMoveLocation = j; 
//                        if(currentScore == Integer.MAX_VALUE/2){b.undoMove(j);break;}
//                    }
//                    
//                    maxScore = Math.max(currentScore, maxScore);
//                    
//                    alpha = Math.max(currentScore, alpha);  
//            } 
//            else if(turn==2){
//                    b.placeMove(j, 2);
//                    currentScore = minimax(depth+1, 1, alpha, beta);
//                    minScore = Math.min(currentScore, minScore);
//                    
//                    beta = Math.min(currentScore, beta); 
//            }  
//            b.undoMove(j); 
//            if(currentScore == Integer.MAX_VALUE || currentScore == Integer.MIN_VALUE) break; 
//        }  
//        return turn==1?maxScore:minScore;
//    }
//    
//    public int getAIMove(){
//        nextMoveLocation = -1;
//        minimax(0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        return nextMoveLocation;
//    }
//    
//    public void playAgainstAIConsole(){
//        int humanMove=-1;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Would you like to play first? (yes/no) ");
//        String answer = scan.next().trim();
//        
//       if(answer.equalsIgnoreCase("yes")) letOpponentMove();
//        b.displayBoard();
//        b.placeMove(3, 1);
//        b.displayBoard();
//        
//        while(true){ 
//            letOpponentMove();
//            b.displayBoard();
//            
//            int gameResult = gameResult(b);
//            if(gameResult==1){System.out.println("AI Wins!");break;}
//            else if(gameResult==2){System.out.println("You Win!");break;}
//            else if(gameResult==0){System.out.println("Draw!");break;}
//            
//            b.placeMove(getAIMove(), 1);
//            b.displayBoard();
//            gameResult = gameResult(b);
//            if(gameResult==1){System.out.println("AI Wins!");break;}
//            else if(gameResult==2){System.out.println("You Win!");break;}
//            else if(gameResult==0){System.out.println("Draw!");break;}
//        }
//        
//    }
    
  }
}
