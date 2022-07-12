import java.util.*;

public class Main {
    static ArrayList<Integer> userPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();


    public static void main(String[] args) {
     char[][] gameBoard={{' ', '|',' ', '|',' '},
                        { '-','+','-','+','-'},
                        { ' ', '|',' ', '|',' '},
                        { '-','+','-','+','-'},
                        { ' ', '|',' ', '|',' '},
     };
        gameBoard(gameBoard);


        while (true){
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter your placement!! from 1 to 9: ");

            int userPost = scanner.nextInt();
            while (userPosition.contains(userPost) || cpuPosition.contains(cpuPosition)){
           System.out.println("Position taken!!");
            userPost = scanner.nextInt();
}
            //System.out.println(userPosition);
            placePiece(gameBoard,userPost, "player");
            String result = checkedWinner();
            if(result.length() > 0){
                //System.out.println(result);
               // break;
            }
            Random random = new Random();
            int cpuRandom = random.nextInt(9)+1;
            while (userPosition.contains(cpuRandom) || cpuPosition.contains(cpuRandom)){
             //   System.out.println("Position taken!!");
                cpuRandom = random.nextInt(9)+1;
            }
            placePiece(gameBoard,cpuRandom, "cpu");

            gameBoard(gameBoard);
             result = checkedWinner();
            if(result.length() > 0){
                System.out.println(result);
           // break;
            }
           //System.out.println( result);
        }

            }
    public static void gameBoard(char[][] gameBoard){
        // nested loop to print out game board
        for(char[] row: gameBoard){
            for(char newRow: row){
                System.out.print(newRow);
            }
            System.out.println(' ');
        }


    }
    public static void placePiece(char[] [] gameBoard, int post, String user){
 char symbols = 'X';
        if(user.equals("player")){
            symbols = 'X';
            userPosition.add(post);
 }else if(user.equals("cpu")) {
            symbols = 'O';
            cpuPosition.add(post);
        }
        switch (post) {
            case 1:
                gameBoard[0][0] = symbols;
                break;
            case 2:
                gameBoard[0][2] = symbols;
                break;
            case 3:
                gameBoard[0][4] = symbols;
                break;
            case 4:
                gameBoard[2][0] = symbols;
                break;
            case 5:
                gameBoard[2][2] = symbols;
                break;
            case 6:
                gameBoard[2][4] = symbols;
                break;
            case 7:
                gameBoard[4][0] = symbols;
                break;
            case 8:
                gameBoard[4][2] = symbols;
                break;
            case 9:
                gameBoard[4][4] = symbols;
                break;

        }
        }
        public static String checkedWinner(){
            List topRow = Arrays.asList(1,2,3);
            List midRow = Arrays.asList(4,5,6);
            List botRow = Arrays.asList(7,8,9);
            List leftCol = Arrays.asList(1,4,7);
            List midCol = Arrays.asList(2,5,8);
            List rightCol = Arrays.asList(3,6,9);
            List cross1 = Arrays.asList(1,5,9);
            List cross2 = Arrays.asList(7,5,3);

            List<List> winnerCondition = new ArrayList<List>();
            winnerCondition.add(topRow);
            winnerCondition.add(midRow);
            winnerCondition.add(botRow);
            winnerCondition.add(leftCol);
            winnerCondition.add(midCol);
            winnerCondition.add(rightCol);
            winnerCondition.add(cross1);
            winnerCondition.add(cross2);
        for(List winningList: winnerCondition){
            if(userPosition.containsAll(winningList)){
                return "Congrats you won this game!!!";
            }else if(cpuPosition.containsAll(winningList)) {
                return " Computer won!! Sorry ";
            } else if(userPosition.size() + cpuPosition.size() == 9){
                return  " you are tie!!";
            }
        }


        return " ";
        }
}