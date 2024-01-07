import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

public class GoalWord {
	
	static ArrayList<String> wb;
	private static String test [] =  {"b", "r", "a", "i", "n"};
	private static String goalword = "";
	
	//flickers for the letters that are on spot
	private boolean gs1 = false;
	private boolean gs2 = false;
	private boolean gs3 = false;
	private boolean gs4 = false;
	private boolean gs5 = false;
	
	//flickers for the letters that arent on spot
	private boolean ys1 = false;
	private boolean ys2 = false;
	private boolean ys3 = false;
	private boolean ys4 = false;
	private boolean ys5 = false;

	public GoalWord() {
		wb = new ArrayList<String>();
	}

	public void wordBank() {
		wb.add("abuse");
		wb.add("adult");
		wb.add("agent");
		wb.add("anger");
		wb.add("apple");
		wb.add("award");
		wb.add("basis");
		wb.add("beach");
		wb.add("birth");
		wb.add("block");
		wb.add("blood");
		wb.add("board");
		wb.add("brain");
		wb.add("bread");
		wb.add("break");
		wb.add("brown");
		wb.add("buyer");
		wb.add("cause");
		wb.add("chain");
		wb.add("chair");
		wb.add("chest");
		wb.add("chief");
		wb.add("child");
		wb.add("china");
		wb.add("claim");
		wb.add("class");
		wb.add("clock");
		wb.add("coach");
		wb.add("coast");
		wb.add("court");
		wb.add("cover");
		wb.add("cream");
		wb.add("crime");
		wb.add("cross");
		wb.add("crowd");
		wb.add("crown");
		wb.add("cycle");
		wb.add("dance");
		wb.add("death");
		wb.add("depth");
		wb.add("dicks");
		wb.add("doubt");
		wb.add("draft");
		wb.add("drama");
		wb.add("dream");
		wb.add("dress");
		wb.add("drink");
		wb.add("drive");
		wb.add("earth");
		wb.add("enemy");
		wb.add("entry");
		wb.add("error");
		wb.add("event");
		wb.add("faith");
		wb.add("fault");
		wb.add("field");
		wb.add("fight");
		wb.add("final");
		wb.add("floor");
		wb.add("focus");
		wb.add("force");
		wb.add("frame");
		wb.add("frank");
		wb.add("front");
		wb.add("fruit");
		wb.add("glass");
		wb.add("grant");
		wb.add("glass");
		wb.add("grant");
		wb.add("grass");
		wb.add("green");
		wb.add("group");
		wb.add("guide");
		wb.add("heart");
		wb.add("henry");
		wb.add("horse");
		wb.add("horny");
		wb.add("hotel");
		wb.add("house");
		wb.add("image");
		wb.add("index");
		wb.add("input");
		wb.add("issue");
		wb.add("japan");
		wb.add("jones");
		wb.add("judge");
		wb.add("knife");
		wb.add("laura");
		wb.add("layer");
		wb.add("level");
		wb.add("lewis");
		wb.add("light");
		wb.add("limit");
		wb.add("lunch");
		wb.add("major");
		wb.add("march");
		wb.add("match");
		wb.add("metal");
		wb.add("model");
		wb.add("money");
		wb.add("month");
		wb.add("motor");
		wb.add("mouth");
		wb.add("music");
		wb.add("night");
		wb.add("noise");
		wb.add("north");
		wb.add("novel");
		wb.add("nurse");
		wb.add("offer");
		wb.add("order");
		wb.add("other");
		wb.add("owner");
		wb.add("panel");
		wb.add("paper");
		wb.add("party");
		wb.add("peace");
		wb.add("peter");
		wb.add("phase");
		wb.add("phone");
		wb.add("piece");
		wb.add("pilot");
		wb.add("pitch");
		wb.add("place");
		wb.add("plane");
		wb.add("plant");
		wb.add("plate");
		wb.add("point");
		wb.add("pound");
		wb.add("power");
		wb.add("press");
		wb.add("price");
		wb.add("pride");
		wb.add("prize");
		wb.add("proof");
		wb.add("queen");
		wb.add("radio");
		wb.add("range");
		wb.add("ratio");
		wb.add("reply");
		wb.add("right");
		wb.add("river");
		wb.add("round");
		wb.add("route");
		wb.add("rugby");
		wb.add("scale");
		wb.add("scene");
		wb.add("scope");
		wb.add("score");
		wb.add("sense");
		wb.add("shape");
		wb.add("share");
		wb.add("sheep");
		wb.add("sheet");
		wb.add("shift");
		wb.add("shirt");
		wb.add("shock");
		wb.add("sight");
		wb.add("simon");
		wb.add("skill");
		wb.add("sleep");
		wb.add("smile");
		wb.add("smith");
		wb.add("smoke");
		wb.add("sound");
		wb.add("south");
		wb.add("space");
		wb.add("speed");
		wb.add("spite");
		wb.add("sport");
		wb.add("squad");
		wb.add("staff");
		wb.add("stage");
		wb.add("start");
		wb.add("state");
		wb.add("steam");
		wb.add("steel");
		wb.add("stock");
		wb.add("stone");
		wb.add("store");
		wb.add("study");
		wb.add("stuff");
		wb.add("style");
		wb.add("sugar");
		wb.add("table");
		wb.add("taste");
		wb.add("terry");
		wb.add("theme");
		wb.add("thing");
		wb.add("title");
		wb.add("total");
		wb.add("touch");
		wb.add("tower");
		wb.add("track");
		wb.add("trade");
		wb.add("train");
		wb.add("trend");
		wb.add("trial");
		wb.add("trust");
		wb.add("truth");
		wb.add("uncle");
		wb.add("union");
		wb.add("unity");
		wb.add("value");
		wb.add("video");
		wb.add("visit");
		wb.add("voice");
		wb.add("waste");
		wb.add("watch");
		wb.add("water");
		wb.add("while");
		wb.add("white");
		wb.add("whole");
		wb.add("woman");
		wb.add("world");
		wb.add("youth");
	}
	
	public void pick() {
		int pick = (int) (Math.random()*wb.size());
		goalword = wb.get(pick);
	}
	
	public void check(String[] s)  {
		
		//every character of the goal word
		String c0 = "";
		String c1 = "";
		String c2 = "";
		String c3 = "";
		String c4 = "";
		
		//assign them values
		c0 = goalword.substring(0, 1);
		c1 = goalword.substring(1, 2);
		c2 = goalword.substring(2, 3);
		c3 = goalword.substring(3, 4);
		c4 = goalword.substring(4, 5);
		
		//letter 1 of the word
		if(s[0].equals(c0))  {//if the letter is the goal word letter
			gs1 = true;
			//system.out.println("letter 1 of the test word is a goal word letter");
		}
		if(s[0].equals(c1) || s[0].equals(c2) || s[0].equals(c3) || s[0].equals(c4))  {//if the letter is one of the goal word letter
			ys1 = true;
			//system.out.println("letter 1 of the test word is one of the goal word letters");
		}
		
		//letter 2 of the word
		if(s[1].equals(c1))  {//if the letter is the goal word letter
			gs2 = true;
			//system.out.println("letter 2 of the test word is a goal word letter");
		}
		if(s[1].equals(c0) || s[1].equals(c2) || s[1].equals(c3) || s[1].equals(c4))  {//if the letter is one of the goal word letter
			ys2 = true;
			//system.out.println("letter 2 of the test word is one of the goal word letters");
		}
		
		//letter 3 of the word
		if(s[2].equals(c2))  {//if the letter is the goal word letter
			gs3 = true;
			//system.out.println("letter 3 of the test word is a goal word letter");
		}
		if(s[2].equals(c1) || s[2].equals(c0) || s[2].equals(c3) || s[2].equals(c4))  {//if the letter is one of the goal word letter
			ys3 = true;
			//system.out.println("letter 3 of the test word is one of the goal word letters");
		}
		
		//letter 4 of the word
		if(s[3].equals(c3))  {//if the letter is the goal word letter
			gs4 = true;
			//system.out.println("letter 4 of the test word is a goal word letter");
		}
		if(s[3].equals(c1) || s[3].equals(c2) || s[3].equals(c0) || s[3].equals(c4))  {//if the letter is one of the goal word letter
			ys4 = true;
			//system.out.println("letter 4 of the test word is one of the goal word letters");
		}
		
		//letter 5 of the word
		if(s[4].equals(c4))  {//if the letter is the goal word letter
			gs5 = true;
			//system.out.println("letter 5 of the test word is a goal word letter");
		}
		if(s[4].equals(c1) || s[4].equals(c2) || s[4].equals(c3) || s[4].equals(c0))  {//if the letter is one of the goal word letter
			ys5 = true;
			//system.out.println("letter 5 of the test word is one of the goal word letters");
		}
		
		//printing out the goal word
//		System.out.println("goalword is: " + c0 + c1 + c2 + c3 + c4);
	}
	
	public void drawBox(Graphics g, int y)  {
		
		if (ys1) {
			g.setColor(Color.yellow);
			g.fillRect(155, 105 + 100 * y, 95, 95);
		}
		if (ys2) {
			g.setColor(Color.yellow);
			g.fillRect(255, 105 + 100 * y, 95, 95);
		}
		if (ys3) {
			g.setColor(Color.yellow);
			g.fillRect(355, 105 + 100 * y, 95, 95);
		}
		if (ys4) {
			g.setColor(Color.yellow);
			g.fillRect(455, 105 + 100 * y, 95, 95);
		}
		if (ys5) {
			g.setColor(Color.yellow);
			g.fillRect(555, 105 + 100 * y, 95, 95);
		}
		if (gs1) {
			g.setColor(Color.green);
			g.fillRect(155, 105 + 100 * y, 95, 95);
		}
		if (gs2) {
			g.setColor(Color.green);
			g.fillRect(255, 105 + 100 * y, 95, 95);
		}
		if (gs3) {
			g.setColor(Color.green);
			g.fillRect(355, 105 + 100 * y, 95, 95);
		} 
		if (gs4) {
			g.setColor(Color.green);
			g.fillRect(455, 105 + 100 * y, 95, 95);
		}
		if (gs5) {
			g.setColor(Color.green);
			g.fillRect(555, 105 + 100 * y, 95, 95);
		}
	}
	
	public int fCheck(int line, String[] s)  {
		
		//every character of the goal word
		String c0 = "";
		String c1 = "";
		String c2 = "";
		String c3 = "";
		String c4 = "";
		
		//assign them values
		c0 = goalword.substring(0, 1);
		c1 = goalword.substring(1, 2);
		c2 = goalword.substring(2, 3);
		c3 = goalword.substring(3, 4);
		c4 = goalword.substring(4, 5);
		
		if(line <= 5)  {
			if(s[0].equals(c0) && s[1].equals(c1) && s[2].equals(c2) && s[3].equals(c3) && s[4].equals(c4))  {
				return 1;
			}
		}
		if(line == 6)  {
			if(s[0].equals(c0) && s[1].equals(c1) && s[2].equals(c2) && s[3].equals(c3) && s[4].equals(c4))  {
				return 1;
			}
			else  {
				return 2;
			}
		}
		return 0;
	}
	
	public void reset()  {
		gs1 = false;
		gs2 = false;
		gs3 = false;
		gs4 = false;
		gs5 = false;
		ys1 = false;
		ys2 = false;
		ys3 = false;
		ys4 = false;
		ys5 = false;
	}
	
	public String getGoalWord()  {
		return goalword;
	}

	public static void main(String[] args) {
		GoalWord word = new GoalWord();
		word.wordBank();
		word.pick();
		word.check(test);
		
		System.out.print("the test word is: ");
		for(int i = 0; i < test.length; i++)  {
			System.out.print(test[i]);
		}
	}
}