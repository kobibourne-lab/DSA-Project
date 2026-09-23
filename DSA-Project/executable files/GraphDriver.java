//Students: Kobi Bourne 
//          Sarah Crotty
//Purpose: Driver to show functionality
public class GraphDriver 
{
    public static void main(String [] args)
    {

        Graphs walks = new Graphs(); //new graph object

        walks.Search("The Lords Woods"); //prints connections from the lords woods
        walks.AllCons("Rathwood"); //prints all sites connected to rathwood
        walks.Closest("Sally's Gap"); //prints closest to sally's gap
        walks.Insert("The Lords Woods", "Mullaghreelan Woods", 3.3); //adds connection
        walks.Search("The Lords Woods"); //check added connection



    }

}