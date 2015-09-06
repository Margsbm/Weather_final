package il.ac.hit.weather.data.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import org.json.JSONException;

import java.awt.SystemColor;

public class GUI {

	private JFrame frame;
	private JTextField txtYourCityName;
    WeatherData weatherData = new WeatherData();
    
	String[] splits;
	String message= "";
	Location location = new Location();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		setFrame(new JFrame());
		getFrame().setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E:\\img.jpg")))));
		//frame.getContentPane().setForeground(new Color(25, 25, 112));
		getFrame().setBackground(new Color(105, 105, 105));
		getFrame().setBounds(100, 100, 399, 569);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Made by Margarita Simbirsky & Igor Korchagin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 337, 26);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 69, 0));
		
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(159, 46, 75, 26);
		getFrame().getContentPane().add(btnNewButton);
		
		txtYourCityName = new JTextField();
		txtYourCityName.setToolTipText("Enter city name in format City,Country");
		txtYourCityName.setBounds(244, 48, 129, 23);
		getFrame().getContentPane().add(txtYourCityName);
		txtYourCityName.setColumns(10);
		
		JLabel lblWeatherDataTitle = new JLabel("Weather in your city\r\n");
		lblWeatherDataTitle.setForeground(new Color(255, 69, 0));
		lblWeatherDataTitle.setBackground(SystemColor.activeCaption);
		lblWeatherDataTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblWeatherDataTitle.setBounds(24, 101, 129, 23);
		lblWeatherDataTitle.setVisible(false);
		getFrame().getContentPane().add(lblWeatherDataTitle);
		
		JLabel lblGeneralDescription = new JLabel("Clear 31 C");
		lblGeneralDescription.setBounds(24, 156, 325, 26);
		lblGeneralDescription.setVisible(false);
		lblGeneralDescription.setForeground(Color.WHITE);
		getFrame().getContentPane().add(lblGeneralDescription);
		
		JLabel lblClouds = new JLabel("Clouds");
		lblClouds.setBounds(24, 182, 337, 23);
		lblClouds.setVisible(false);
		getFrame().getContentPane().add(lblClouds);
		
		JLabel lblSysDateTime = new JLabel("get at");
		lblSysDateTime.setBounds(24, 204, 325, 26);
		lblSysDateTime.setForeground(Color.WHITE);
		lblSysDateTime.setVisible(false);
		getFrame().getContentPane().add(lblSysDateTime);
		
		JLabel lblCityCountry = new JLabel("City , Country");
		lblCityCountry.setBounds(24, 135, 325, 26);
		lblCityCountry.setForeground(Color.WHITE);
		lblCityCountry.setVisible(false);
		getFrame().getContentPane().add(lblCityCountry);
		
		JLabel lblCloudness = new JLabel("Cloudiness");
		lblCloudness.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCloudness.setForeground(Color.WHITE);
		lblCloudness.setBounds(24, 272, 102, 32);
		lblCloudness.setVisible(false);
		getFrame().getContentPane().add(lblCloudness);
		
		JLabel lblPressure = new JLabel("Pressure");
		lblPressure.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressure.setForeground(Color.WHITE);
		lblPressure.setBounds(24, 313, 102, 32);
		lblPressure.setVisible(false);
		getFrame().getContentPane().add(lblPressure);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHumidity.setForeground(Color.WHITE);
		lblHumidity.setBounds(24, 356, 102, 32);
		lblHumidity.setVisible(false);
		getFrame().getContentPane().add(lblHumidity);
		
		JLabel lblMax = new JLabel("max  t");
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMax.setForeground(Color.WHITE);
		lblMax.setBounds(24, 400, 102, 32);
		lblMax.setVisible(false);
		getFrame().getContentPane().add(lblMax);
		
		JLabel lblMin = new JLabel("min  t");
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMin.setForeground(Color.WHITE);
		lblMin.setBounds(24, 443, 102, 32);
		lblMin.setVisible(false);
		getFrame().getContentPane().add(lblMin);
		
		JLabel lblGeo = new JLabel("Geo coords\t");
		lblGeo.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeo.setForeground(Color.WHITE);
		lblGeo.setBounds(24, 486, 102, 32);
		lblGeo.setVisible(false);
		getFrame().getContentPane().add(lblGeo);
		
		JLabel lblLine = new JLabel("-----------------------------------------------------------------------------------");
		lblLine.setBounds(20, 241, 353, 14);
		lblLine.setForeground(Color.WHITE);
		lblLine.setVisible(false);
		getFrame().getContentPane().add(lblLine);
		
		JLabel lblCloudnessValue = new JLabel("Cloudiness value");
		lblCloudnessValue.setForeground(Color.WHITE);
		lblCloudnessValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCloudnessValue.setBackground(Color.BLACK);
		lblCloudnessValue.setBounds(147, 272, 102, 32);
		lblCloudnessValue.setVisible(false);
		getFrame().getContentPane().add(lblCloudnessValue);
		
		JLabel lblPressureValue = new JLabel("Pressure value");
		lblPressureValue.setForeground(Color.WHITE);
		lblPressureValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressureValue.setBackground(Color.BLACK);
		lblPressureValue.setBounds(147, 313, 102, 32);
		lblPressureValue.setVisible(false);
		getFrame().getContentPane().add(lblPressureValue);
		
		JLabel lblHumidityValue = new JLabel("Humidity value");
		lblHumidityValue.setForeground(Color.WHITE);
		lblHumidityValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHumidityValue.setBackground(Color.BLACK);
		lblHumidityValue.setBounds(147, 356, 102, 32);
		lblHumidityValue.setVisible(false);
		getFrame().getContentPane().add(lblHumidityValue);
		
		JLabel lblMaxValue = new JLabel("max  t value");
		lblMaxValue.setForeground(Color.WHITE);
		lblMaxValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaxValue.setBackground(Color.BLACK);
		lblMaxValue.setBounds(147, 400, 102, 32);
		lblMaxValue.setVisible(false);
		getFrame().getContentPane().add(lblMaxValue);
		
		JLabel lblMinValue = new JLabel("min  t value");
		lblMinValue.setForeground(Color.WHITE);
		lblMinValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMinValue.setBackground(Color.BLACK);
		lblMinValue.setBounds(147, 443, 102, 32);
		lblMinValue.setVisible(false);
		getFrame().getContentPane().add(lblMinValue);
		
		JLabel lblGeoValue = new JLabel("Geo coords\t value");
		lblGeoValue.setForeground(Color.WHITE);
		lblGeoValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblGeoValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeoValue.setBackground(Color.BLACK);
		lblGeoValue.setBounds(147, 486, 102, 32);
		lblGeoValue.setVisible(false);
		getFrame().getContentPane().add(lblGeoValue);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblMessage.setForeground(Color.cyan);
		lblMessage.setBounds(23, 76, 350, 14);
		lblMessage.setVisible(false);
		getFrame().getContentPane().add(lblMessage);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameCity = txtYourCityName.getText().replaceAll("\\s+","");;
				splits = nameCity.split("\\,");
			
						if(nameCity.contains(",")){
								splits = nameCity.split("\\,");
								location.setCity(splits[0]);
								location.setCountry(","+splits[1]);
						}else{
							location.setCity(nameCity);
							location.setCountry("");
								message = "If you wanted City in another coutry,please anter Country code";
							}
				
						_RunService first = new _RunService();
						try
						{
							
								lblMessage.setText(message);
								lblMessage.setVisible(true);
								
							
							weatherData = first.runWeatherService(location);
							
							if(weatherData.getCodMessage()== null){
							
							lblCityCountry.setText(weatherData.getCity()+" , "+weatherData.getCountry());
							lblCityCountry.setVisible(true);
							Double value= new Double(weatherData.getAvg_current_temp());
							lblGeneralDescription.setText(weatherData.getWeather_general_desc()+ " , "+  RoundTo2Decimals(value/10) +" C");
							lblGeneralDescription.setVisible(true);
								DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
								Date date = new Date(); 
			                lblSysDateTime.setText("get at "+dateFormat.format(date)+" ,local time");
			                lblSysDateTime.setVisible(true);
			                
			                lblCloudness.setVisible(true);
			                lblCloudnessValue.setText(weatherData.getWeather_desc());
			                lblCloudnessValue.setVisible(true);
			                
			                lblPressure.setVisible(true);
			                lblPressureValue.setText(weatherData.getPressure()+"  hpa");
			                lblPressureValue.setVisible(true);
			                
			                lblHumidity.setVisible(true);
			                lblHumidityValue.setText(weatherData.getHumidity()+" %");
			                lblHumidityValue.setVisible(true);
			                
			                lblLine.setVisible(true);
			                
			                lblMax.setVisible(true);
			                Double valueMax= new Double(weatherData.getAvg_max_temp());
			                lblMaxValue.setText(RoundTo2Decimals(valueMax/10) +" C");
			                lblMaxValue.setVisible(true);
			                
			                lblMin.setVisible(true);
			                Double valueMin= new Double(weatherData.getAvg_min_temp());
			                lblMinValue.setText(RoundTo2Decimals(valueMin/10) +" C");
			                lblMinValue.setVisible(true);
			                
			                lblWeatherDataTitle.setVisible(true);
			                
			                lblGeo.setVisible(true);
			                lblGeoValue.setText("[ "+weatherData.getCoord1()+" , "+weatherData.getCoord2()+" ]");
			                lblGeoValue.setVisible(true);
							}else{
								
								lblMessage.setText(weatherData.getCodMessage().toString());
								lblMessage.setFont(new Font("Tahoma", Font.ITALIC, 12));
								lblMessage.setForeground(Color.red);
								lblMessage.setBounds(23, 76, 350, 14);
								lblMessage.setVisible(true);
								
								lblCityCountry.setVisible(false);
								lblGeneralDescription.setVisible(false);
								lblSysDateTime.setVisible(false);
				                
				                lblCloudness.setVisible(false);
				                lblCloudnessValue.setVisible(false);
				                
				                lblPressure.setVisible(false);
				                lblPressureValue.setVisible(false);
				                
				                lblHumidity.setVisible(false);
				                lblHumidityValue.setVisible(false);
				                
				                lblLine.setVisible(false);
				                
				                lblMax.setVisible(false);
				                lblMaxValue.setVisible(false);
				                
				                lblMin.setVisible(false);
				                lblMinValue.setVisible(false);
				                
				                lblWeatherDataTitle.setVisible(false);
				                
				                lblGeo.setVisible(false);
				               lblGeoValue.setVisible(false);
							}
						} catch (JSONException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1)
						{
							//new WeatherDataServiceException(nameCity).printStackTrace();
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
              
			}
		});
	}
	String RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.#");
    return Double.valueOf(df2.format(val)).toString();
}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
