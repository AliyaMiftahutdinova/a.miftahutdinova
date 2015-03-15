public class FileFinder{
	
	public static void main(String [] args){
        if(args == null || args.length > 5 || args.length < 3){
            System.out.println("Wrong data");
        }else if(args.length == 3){
            if(args[0].equals("-R") || args[0].equals("-r")){
                new Searcher().find(args[1], args[2], Double.POSITIVE_INFINITY, false);
                System.out.print("Finish");
            }else{
                System.out.println("Wrong data");
            }
        }else if(args.length == 4){
            if((args[0].equals("-R") || args[0].equals("-r")) && (args[1].equals("-V") || args[1].equals("-v"))){
                new Searcher().find(args[2], args[3], Double.POSITIVE_INFINITY, true);
                System.out.print("Finish");
            }else if(args[0].equals("-D") || args[0].equals("-d")){
                try {
                    Integer deep = new Integer(args[1]);
                    if(deep > 0){
                        new Searcher().find(args[2], args[3], deep, false);
                        System.out.print("Finish");
                    }else{
                        System.err.println("Wrong deep");
                    }
                }catch (NumberFormatException e) {
                    System.err.println("Wrong deep");
                }
            }else {
                System.out.println("Wrong data");
            }
        }else if(args.length == 5){
            if((args[0].equals("-D") || args[0].equals("-d")) && (args[2].equals("-V") || args[1].equals("-v"))){
                try {
                    Integer deep = new Integer(args[1]);
                    if(deep > 0){
                        new Searcher().find(args[3], args[4], deep, true);
                        System.out.print("Finish");
                    }else{
                        System.err.println("Wrong deep");
                    }
                }catch (NumberFormatException e) {
                    System.err.println("Wrong deep");
                }
            }else{
                System.out.println("Wrong data");
            }
        }
	}
	
}
