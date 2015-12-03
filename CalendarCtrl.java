import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class CalendarCtrl implements Initializable{

    HashMap<Integer, Integer> mapMouth = new HashMap<Integer, Integer>();
	LocalDate dayTarget;

	@FXML
	ImageView btnMonthSuiv,btnMonthPrec;
	@FXML
	Label lblMouthYear;	
	@FXML
	Label case01,case02,case03,case04,case05,case06,case07,case08,case09,
	case10,case11,case12,case13,case14,case15,case16,case17,case18,case19,
	case20,case21,case22,case23,case24,case25,case26,case27,case28,case29,
	case30,case31,case32,case33,case34,case35,case36,case37,case38,case39,
	case40,case41,case42,day1,day2,day3,day4,day5,day6,day7;
	
	public String getMounth(int mouth){
		switch(mouth){
		case 1:
				return "January";
		case 2:
				return "Febrary";
		case 3:
				return "March";
		case 4:
				return "April";
		case 5:
				return "May";
		case 6:
				return "June";
		case 7:
				return "July";
		case 8:
				return "Augest";
		case 9:
				return "September";
		case 10:
				return "October";
		case 11:
				return "November";
		case 12:
				return "December";
		}
		return null;
	}
	
	/**Retourne la nombre du jour d'un mois courant.*/
	private int getMonthLength(LocalDate date){
		int monthLength=30;
		if((date.getMonthValue()==1)||(date.getMonthValue()==3)||(date.getMonthValue()==5)||(date.getMonthValue()==7)||(date.getMonthValue()==8)||(date.getMonthValue()==10)||(date.getMonthValue()==12)){
			monthLength=31;
	    }else if(date.getMonthValue()==2){
	    	if(date.isLeapYear()){
	    		monthLength=29;
	    	}else{
	    		monthLength=28;
	    	}
	    }else{
	    	monthLength=30;
	    }
		return monthLength;
	}
	
	/**Retourne la nombre du jour d'un mois précédent.*/
	private int getPrecMonthLength(LocalDate date){
		int monthLength=30;
		if((date.getMonthValue()-1==1)||(date.getMonthValue()-1==3)||(date.getMonthValue()-1==5)||(date.getMonthValue()-1==7)||(date.getMonthValue()-1==8)||(date.getMonthValue()-1==10)||(date.getMonthValue()-1==12)){
			monthLength=31;
	    }else if(date.getMonthValue()-1==2){
	    	if(date.isLeapYear()){
	    		monthLength=29;
	    	}else{
	    		monthLength=28;
	    	}
	    }else{
	    	monthLength=30;
	    }
		return monthLength;
	}
	
	/**Retourne la case de premiere jour de mois.*/
	private int getFirstDayCase(LocalDate date){
		int firstCase = 1;
		LocalDate firstDate;
		if(date.getMonthValue()<10){
			firstDate=LocalDate.parse(date.getYear()+"-0"+date.getMonthValue()+"-01");
		}else{
			firstDate=LocalDate.parse(date.getYear()+"-"+date.getMonthValue()+"-01");
		}
		firstCase=firstDate.getDayOfWeek().getValue();
		return firstCase;
	}
	
	/**Initialise les jours visibles de mois précédent.*/
	private void intiDaysOfPrecMonth(LocalDate today){
		int monthLength=getPrecMonthLength(today);

		int dayOfMonth=monthLength;
		for(int i=getFirstDayCase(today)-1;i>0;i--){
			mapMouth.put(i,dayOfMonth);
			dayOfMonth--;
		}
	}
	
	/**Initialise les jours visibles de mois courant.*/
	private void intiDaysOfThisMonth(LocalDate today){
		int monthLength=getMonthLength(today);
		int dayOfMonth=1;
		
		for(int i=getFirstDayCase(today);i<=getFirstDayCase(today)+monthLength;i++){
			mapMouth.put(i,dayOfMonth);
			dayOfMonth++;
		}
	}
	
	/**Initialise les jours visibles de mois suivant.*/
	private void intiDaysOfNextMonth(LocalDate today){
		int dayOfMonth=1;
		int monthLength=getMonthLength(today);

		for(int i=monthLength+getFirstDayCase(today);i<=42;i++){
			mapMouth.put(i,dayOfMonth);
			dayOfMonth++;
		}
	}
	
	/**Initialise les cases jours de calendrier.*/
	public void initDaysOfMounth(LocalDate today){
		intiDaysOfPrecMonth(today);
		intiDaysOfThisMonth(today);
		intiDaysOfNextMonth(today);
		lblMouthYear.setText(getMounth(today.getMonthValue())+", "+today.getYear());
		System.out.println("Date: "+today.toString());
		case01.setText(mapMouth.get(1)+"");
		case02.setText(mapMouth.get(2)+"");
		case03.setText(mapMouth.get(3)+"");
		case04.setText(mapMouth.get(4)+"");
		case05.setText(mapMouth.get(5)+"");
		case06.setText(mapMouth.get(6)+"");
		case07.setText(mapMouth.get(7)+"");
		case08.setText(mapMouth.get(8)+"");
		case09.setText(mapMouth.get(9)+"");
		case10.setText(mapMouth.get(10)+"");
		case11.setText(mapMouth.get(11)+"");
		case12.setText(mapMouth.get(12)+"");
		case13.setText(mapMouth.get(13)+"");
		case14.setText(mapMouth.get(14)+"");
		case15.setText(mapMouth.get(15)+"");
		case16.setText(mapMouth.get(16)+"");
		case17.setText(mapMouth.get(17)+"");
		case18.setText(mapMouth.get(18)+"");
		case19.setText(mapMouth.get(19)+"");
		case20.setText(mapMouth.get(20)+"");
		case21.setText(mapMouth.get(21)+"");
		case22.setText(mapMouth.get(22)+"");
		case23.setText(mapMouth.get(23)+"");
		case24.setText(mapMouth.get(24)+"");
		case25.setText(mapMouth.get(25)+"");
		case26.setText(mapMouth.get(26)+"");
		case27.setText(mapMouth.get(27)+"");
		case28.setText(mapMouth.get(28)+"");
		case29.setText(mapMouth.get(29)+"");		
		case30.setText(mapMouth.get(30)+"");
		case31.setText(mapMouth.get(31)+"");
		case32.setText(mapMouth.get(32)+"");
		case33.setText(mapMouth.get(33)+"");
		case34.setText(mapMouth.get(34)+"");		
		case35.setText(mapMouth.get(35)+"");
		case36.setText(mapMouth.get(36)+"");
		case37.setText(mapMouth.get(37)+"");
		case38.setText(mapMouth.get(38)+"");
		case39.setText(mapMouth.get(39)+"");
		case40.setText(mapMouth.get(40)+"");
		case41.setText(mapMouth.get(41)+"");
		case42.setText(mapMouth.get(42)+"");
	}
	
	/**Mois suivant.*/
	@FXML
	private void nextMonth(){
		int m=dayTarget.getMonthValue();
		int a=dayTarget.getYear();
		m++;
		String mois=m+"";
		String ann=a+"";
		if(m<10){
			mois="0"+mois;
		}else if(m>12){
			m=1;
			mois="01";
			a++;
			ann=a+"";
		}
		dayTarget=LocalDate.parse(ann+"-"+mois+"-01");
		initDaysOfMounth(dayTarget);
	}
	
	/**Mois précédent.*/
	@FXML
	private void precMonth(){
		int m=dayTarget.getMonthValue();
		int a=dayTarget.getYear();
		m--;
		String mois=m+"";
		String ann=a+"";
		if(m<10){
			mois="0"+mois;
		}
		if(m==0){
			m=12;
			mois="12";
			a--;
			ann=a+"";
		}
		dayTarget=LocalDate.parse(ann+"-"+mois+"-01");
		initDaysOfMounth(dayTarget);
	}
	
	/**Distinguer les jours de mois précédent de suivant en gris 
	 * et encadre le jour courant.*/
	private void doStyle(int first,int last,int today){
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dayTarget=LocalDate.now();
		initDaysOfMounth(dayTarget);
		doStyle(0,0,0);
	}

}
