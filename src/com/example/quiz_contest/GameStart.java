package com.example.quiz_contest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GameStart extends Activity {

	RadioGroup rg;
	TextView tv;
	Button btn;
	private Cursor p;
	String n;
	private SQLiteDatabase db;
	String q[]={
			"How many yards are there between wickets in a game of cricket",
			"Which is the largest planet in the solar system?",
			"Which of the following is a palindrome?",
			"The word ISPISISPSMI is an anagram of which of the following?",
			"If David travels one mile north, two miles west, one mile north, one mile east, three miles south, one mile east,how far will he be from his starting point?",
			"Which of the following words is most associated with the word INTERMITTENT?",
			"What month was last month if February is in three months?",
			"If the word EWE is written above the word ZOO and the word TOE is written above the word EWE, would the number TWO appear diagonally?",
			"Mia and Tilly have the same amount of sweets each. How many sweets should Mia give Tilly so that she has four sweets more?",
			"Which of the following is least like the others?",
			"Including the white ball, how many color varieties are used in a game of snooker?",
			"Which body part can be placed before the following words? drum ache ring",
			"Which continent has no active volcanoes?",
			"In the fairytale Cinderella, what did Cinderella leave behind as she was leaving the ball?",
			"What year did the American Civil War start?",
			"Which country will host the 2016 Olympics?",
			"Which season would the fall be known as in Great Britain?",
			"Which is not among the three primary colors?",
			"What is an expression of language meaning the opposite?","What is the primary religion in Thailand?",
			"Which is the only body organ able to regenerate itself?","Complete the saying: A picture is worth...?",
			"Dos is Spanish for which number?","How many hours are equal to 600 minutes?",
			"Can you unscramble this word to find the name of a country: SUSAIR?",
			"What is the meaning of the Latin phrase ‘bona fide’?","What do the fifty stars on the US flag represent?",
			"Which country is first to appear in the English dictionary?","What is the last letter of the Greek alphabet?",
			"What name is given to a triangle with one angle greater than 90 degrees?",
			"What is the name of Scooby Doo`s psychedelic van?","What is the largest island in the Caribbean?",
			"Which TV series features a chemistry teacher called Walter White?",
			"Which F.R.I.E.N.D.S. character makes jokes when he is uncomfortable?",
			"If you were born December 4th, which star sign would you belong to?",
			"In the film Shrek, what is the name of Shrek`s wife?","What was the name of the boy in the Jungle Book?",
			"What is the name of the actor who played the role of Harry Potter in the film series?",
			"Which Bond movie did Daniel Craig first star in?","Who played Jack in the film The Titanic?",
			"From which movie did this quote come from: A lie keeps growing and growing until it is as plain as the nose on your face?",
			"How many square meters are there in a hectare?","How many rings does Saturn have around it?",
			"Which of the five senses develops first?","How many carats are there in pure gold?",
			"Who scored the winning penalty in the 2006 world cup final?","How many red balls are used in a game of snooker?",
			"Who has won the most FIFA Ballons d Or?","In which sport is the Davis cup awarded?",
			"At what time did Andres Iniesta score the winning goal to help Spain win their first World Cup ever?"

};
	String a[]={"20","Pluto","yatch","Plant","Zero","Continuous","October","WWE","4","Length","6","Ear","Asia","Earring","1857","Argentina","Autumn","Red"
			,"Similie","Hinduism","Tooth","many words","22","20","Uruguay","in good faith","Presidents","Argentina","Omega","Obtuse","The Mystery Traveller",
			"Cuba","Prison Break","Ross","Gemini","Alice","Timon","Daniel Radcliffe","Spectre","Christan Bale","Toy Story","10000","4","Touch","22",
			"Andrea Pirlo","12","Cristiano Ronaldo","Football","117"};
	String b[]={"18","Jupiter","racecar","Sporting Event","Two","Irregular","November","TEZ","1","Millimeter","7","Stomach","Australia","Glass Slipper",
			"1872","England","Spring","Green","Irony","Jainism","Ear","1000 words","12","10","Russia","for this","States","Algeria","Alpha","Isoceles","The Van",
			"Antigua","F.R.I.E.N.D.S.","Chandler Bing","Aries","Rapunzel","Mowgli","Justin Timberlake","Casino Royale","Mathew McCaughney","Pinocchio",
			"100","3","Smell","24","Marco Matterazi","15","Ronaldinho","Cricket","113"};
	String c[]={"22","Saturn","train","Sea Creature","One","Repetitive","January","OWO","3","Yard","8","Head","Europe","Ring","1867","Brazil","Summer",
			"Blue","Metaphor","Buddhism","Stomach","10 words","2","60","USSR","word for word","50 top cities","Afghanistan","Delta","Acute","The Mystery Van","Barbados",
			"Breaking Bad","Joey","Leo","Fiona","Leo","Rupert Grint","Thunderball","Russel Crowe","Finding Nemo","1","5","Taste","20","Fabio Grosso",
			"9","Lionel Messi","Hockey","93"};
	String d[]={"32","Mercury","car","River","Three","Consistent","September","TWO","2","Meter","4","Foot","Africa","Purse","1861","Russia","Winter",
			"Yellow","Aside","Christanity","Liver","100 words","7","600","USA","after death","50 lakes","Australia","Gamma","Scalene","The Mystery Machine",
			"Galle","Game Of Thrones","Rachel","Saggitarius","Cindrella","Pumba","Kevin McCauley","Skyfall","Leonardo DiCaprio","Ice Age","100","7","Sight",
			"18","Alesandre Del Piero","1","Ronaldo","Tennis","121"};
	int ans[]={2,1,1,3,2,1,0,3,3,0,2,0,1,1,3,2,0,1,1,2,3,1,2,1,1,0,1,2,0,0,3,0,2,1,3,2,1,0,1,3,1,0,3,1,1,2,1,2,3,0};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_start);
		
		Bundle data=getIntent().getExtras();
		n=data.getString("Name");
		btn=(Button)findViewById(R.id.button1);
		//tv.setText(q[0]);
		createDatabase();
		p=db.rawQuery("SELECT * FROM questions", null);
		if(!p.moveToFirst())
		insertDB();
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(), QuizActivity.class);
				i.putExtra("Name", n);
				startActivity(i);
			}
		});
		
	}
	protected void createDatabase()
	{
		db=openOrCreateDatabase("QuizDB.db", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS questions(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, question VARCHAR, opA VARCHAR," +
				"opB VARCHAR, opC VARCHAR,opD VARCHAR,answer NUMBER)");
	}
	protected void insertDB() 
	{
		//tv.setText("Getting the quiz ready...");
		int l=50;
		for(int i=0;i<l;i++)
		{
			String query="INSERT INTO questions(question,opA,opB,opC,opD,answer) values('"+q[i]+"','"+a[i]+"','"+b[i]+
					"','"+c[i]+"','"+d[i]+"','"+ans[i]+"');)";
			db.execSQL(query);
		}
		Toast.makeText(getApplicationContext(), "Application ready to use!", Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
