import java.io.IOException;


public class headerTC {

    public static void header () throws IOException{

        //formatter TC for formatted date and time
        formatterTC timeDate = new formatterTC();

        System.out.println("\n-------------------------------------------------------------------------------------");	//85 dashes for formatting
        System.out.print("\t\t\t\t\tTrade Checker Run: "+timeDate);
        System.out.println("\n-------------------------------------------------------------------------------------");	//85 dashes for formatting
    }

    public static void separator () throws IOException{
        System.out.println("\n-------------------------------------------------------------------------------------");	//85 dashes for formatting
        System.out.println("Diff Report:");
        System.out.println("------------");
    }

    public String ender() throws IOException{
        String end = "-------------------------------------------------------------------------------------";
        return end;
    }
}
