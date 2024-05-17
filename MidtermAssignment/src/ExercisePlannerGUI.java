import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ExercisePlannerGUI {

	// CERTAIN BUTTON LOGIC
	private static int exerciseType;
	private static int enterNum = 0;
	private static int totalExercises = 0;

	// ALL GUI COMPONENTS
	private JFrame frmFitnessPlanner;
	private JLabel exerciseBanner, plannerBanner;
	private JButton swimmingBtn;
	private JButton joggingBtn;
	private JButton tennisBtn;
	private JButton badmintonBtn;
	private JButton yesBtn;
	private JButton noBtn;
	private JTextArea textArea;
	private JPanel panel;
	private JButton oneBtn;
	private JButton twoBtn;
	private JButton threeBtn;
	private JButton fourBtn;
	private JButton fiveBtn;
	private JButton sixBtn;
	private JButton sevenBtn;
	private JButton eightBtn;
	private JButton nineBtn;
	private JButton zeroBtn;
	private JButton cancelBtn;
	private JButton btnClear;
	private JButton btnEnter;

	// UTILITY MEMBERS
	private String numericPart;
	private static final String USERPROMPT = "Choose Exercise (from left menu):";

	// OBJECTS
	Course course;
	Match match;
	Exercise exercise;
	Swimming swim;
	Jogging jog;
	Tennis tennis;
	Badminton badminton;

	private Map<Integer, Exercise> exercises = new HashMap<>();

	public ExercisePlannerGUI() {

		frmFitnessPlanner = new JFrame();
		frmFitnessPlanner.setTitle("Fitness Planner");
		frmFitnessPlanner.setBounds(100, 100, 560, 741);
		frmFitnessPlanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFitnessPlanner.setLocationRelativeTo(null);
		frmFitnessPlanner.getContentPane().setLayout(null);

		exerciseBanner = new JLabel("");
		exerciseBanner.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/fitness_planner_logo.png")));
		exerciseBanner.setBounds(71, 48, 400, 74);
		frmFitnessPlanner.getContentPane().add(exerciseBanner);

		plannerBanner = new JLabel("Fitness Planner");
		plannerBanner.setFont(new Font("Tahoma", Font.BOLD, 20));
		plannerBanner.setBounds(204, 132, 161, 32);
		frmFitnessPlanner.getContentPane().add(plannerBanner);

		swimmingBtn = new JButton("Swimming");
		swimmingBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/swimming.png")));
		swimmingBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		swimmingBtn.setBounds(10, 214, 132, 43);
		swimmingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseType = 1;
				textArea.setText("You choose Swmimming\n" + "Enter Calories Per Distance (kcal / km): ");
			}
		});
		frmFitnessPlanner.getContentPane().add(swimmingBtn);

		joggingBtn = new JButton("Jogging");
		joggingBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/jogging.png")));
		joggingBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		joggingBtn.setBounds(10, 257, 132, 43);
		joggingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseType = 2;
				textArea.setText("You choose Jogging\n" + "Enter Calories Per Distance (kcal / km): ");
			}
		});
		frmFitnessPlanner.getContentPane().add(joggingBtn);

		tennisBtn = new JButton("Tennis");
		tennisBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/tennis.png")));
		tennisBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		tennisBtn.setBounds(10, 299, 132, 43);
		tennisBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseType = 3;
				textArea.setText("You choose Tennis\n" + "Enter Number of Matches: ");
			}
		});
		frmFitnessPlanner.getContentPane().add(tennisBtn);

		badmintonBtn = new JButton("Badminton");
		badmintonBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/badminton.png")));
		badmintonBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		badmintonBtn.setBounds(10, 341, 132, 43);
		badmintonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseType = 4;
				textArea.setText("You choose Badminton\n" + "Enter Number of Matches: ");
			}
		});
		frmFitnessPlanner.getContentPane().add(badmintonBtn);

		yesBtn = new JButton("Yes");
		yesBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/enterSmall.png")));
		yesBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		yesBtn.setBounds(430, 257, 85, 42);
		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = 0;
				textArea.setText(USERPROMPT);
			}
		});
		frmFitnessPlanner.getContentPane().add(yesBtn);

		noBtn = new JButton("No");
		noBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/cancelSmall.png")));
		noBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		noBtn.setBounds(430, 299, 85, 42);
		noBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = 0;
				int i = 1;
				double total = 0;
				textArea.setText(null);
				for (Exercise exercise : exercises.values()) {
					textArea.setText(textArea.getText() + "Exercise " + i++ + ": " + exercise);
					total += exercise.getConsumedCalories();
				}

				textArea.setText(textArea.getText() + "=================================================\n");
				textArea.setText(textArea.getText() + "Total Consumed Calories: " + total + " kcal");

			}
		});
		frmFitnessPlanner.getContentPane().add(noBtn);

		textArea = new JTextArea();
		textArea.setBounds(152, 174, 268, 262);
		textArea.setText(USERPROMPT);
		frmFitnessPlanner.getContentPane().add(textArea);

		panel = new JPanel();
		panel.setBounds(117, 446, 215, 249);
		frmFitnessPlanner.getContentPane().add(panel);
		panel.setLayout(null);

		oneBtn = new JButton("");
		oneBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/1.png")));
		oneBtn.setBounds(1, 0, 70, 60);
		oneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "1");
			}
		});
		panel.add(oneBtn);

		twoBtn = new JButton("");
		twoBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/2.png")));
		twoBtn.setBounds(70, 0, 70, 60);
		twoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "2");
			}
		});
		panel.add(twoBtn);

		threeBtn = new JButton("");
		threeBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/3.png")));
		threeBtn.setBounds(140, 0, 70, 60);
		threeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "3");
			}
		});
		panel.add(threeBtn);

		fourBtn = new JButton("");
		fourBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/4.png")));
		fourBtn.setBounds(1, 63, 70, 60);
		fourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "4");
			}
		});
		panel.add(fourBtn);

		fiveBtn = new JButton("");
		fiveBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/5.png")));
		fiveBtn.setBounds(70, 63, 70, 60);
		fiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "5");
			}
		});
		panel.add(fiveBtn);

		sixBtn = new JButton("");
		sixBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/6.png")));
		sixBtn.setBounds(140, 63, 70, 60);
		sixBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "6");
			}
		});
		panel.add(sixBtn);

		sevenBtn = new JButton("");
		sevenBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/7.png")));
		sevenBtn.setBounds(1, 126, 70, 60);
		sevenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "7");
			}
		});
		panel.add(sevenBtn);

		eightBtn = new JButton("");
		eightBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/8.png")));
		eightBtn.setBounds(70, 126, 70, 60);
		eightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "8");
			}
		});
		panel.add(eightBtn);

		nineBtn = new JButton("");
		nineBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/9.png")));
		nineBtn.setBounds(140, 126, 70, 60);
		nineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "9");
			}
		});
		panel.add(nineBtn);

		zeroBtn = new JButton("");
		zeroBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/0.png")));
		zeroBtn.setBounds(70, 189, 70, 60);
		zeroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "0");
			}
		});
		panel.add(zeroBtn);

		cancelBtn = new JButton("CANCEL");
		cancelBtn.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/cancel.png")));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		cancelBtn.setBounds(335, 446, 161, 60);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterNum = 0;
				exercises.clear();
				textArea.setText("Cancelled!\n" + "New plan:\n" + USERPROMPT);
			}
		});
		frmFitnessPlanner.getContentPane().add(cancelBtn);

		btnClear = new JButton("CLEAR");
		btnClear.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/clear.png")));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(335, 510, 161, 60);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enterNum != 0) {
					textArea.setText(USERPROMPT);
				} else {
					textArea.setText(parseString(textArea.getText()));
				}
			}
		});
		frmFitnessPlanner.getContentPane().add(btnClear);

		btnEnter = new JButton("ENTER");
		btnEnter.setIcon(new ImageIcon(ExercisePlannerGUI.class.getResource("/assets/enter.png")));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnter.setBounds(335, 572, 161, 60);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (exerciseType) {
				case 1:
					enterNum += 1;
					if (enterNum == 1) {
						exercise = new Swimming(new Course());
						if (exercise instanceof Swimming) {
							swim = (Swimming) exercise;
						}
						swim.getCourse().setCaloriePerDistance(parseDoubleNumber(textArea.getText()));
						textArea.setText("Enter distance (in km): ");
					} else if (enterNum == 2) {
						swim.getCourse().setDistance(parseDoubleNumber(textArea.getText()));
						swim.calculateCalories();
						exercises.put(totalExercises++, exercise);
						textArea.setText("Add more exercise(from right menu)? ");
					}
					break;
				case 2:
					enterNum += 1;
					if (enterNum == 1) {
						exercise = new Jogging(new Course());
						if (exercise instanceof Jogging) {
							jog = (Jogging) exercise;
						}
						jog.getCourse().setCaloriePerDistance(parseDoubleNumber(textArea.getText()));
						textArea.setText("Enter distance (in km): ");
					} else if (enterNum == 2) {
						jog.getCourse().setDistance(parseDoubleNumber(textArea.getText()));
						jog.calculateCalories();
						exercises.put(totalExercises++, jog);
						textArea.setText("Add more exercise(from right menu)? ");
					}
					break;
				case 3:
					enterNum += 1;
					if (enterNum == 1) {
						exercise = new Tennis(new Match());
						if (exercise instanceof Tennis) {
							tennis = (Tennis) exercise;
						}
						tennis.setNumMatches(parseIntegerNumber(textArea.getText()));
						textArea.setText("Enter calories per set (kcal / set): ");
					} else if (enterNum == 2) {
						tennis.getMatch().setCaloriePerSet(parseDoubleNumber(textArea.getText()));
						textArea.setText("Enter number of sets: ");
					} else if (enterNum == 3) {
						tennis.getMatch().setNumSets(parseIntegerNumber(textArea.getText()));
						tennis.calculateCalories();
						exercises.put(totalExercises++, tennis);
						textArea.setText("Add more exercise(from right menu)? ");
					}
					break;
				case 4:
					enterNum += 1;
					if (enterNum == 1) {
						exercise = new Badminton(new Match());
						if (exercise instanceof Badminton) {
							badminton = (Badminton) exercise;
						}
						badminton.setNumMatches(parseIntegerNumber(textArea.getText()));
						textArea.setText("Enter calories per set (kcal / set): ");
					} else if (enterNum == 2) {
						badminton.getMatch().setCaloriePerSet(parseDoubleNumber(textArea.getText()));
						textArea.setText("Enter number of sets: ");
					} else if (enterNum == 3) {
						badminton.getMatch().setNumSets(parseIntegerNumber(textArea.getText()));
						badminton.calculateCalories();
						exercises.put(totalExercises++, badminton);
						textArea.setText("Add more exercise(from right menu)? ");
					}
					break;

				}

			}
		});
		frmFitnessPlanner.getContentPane().add(btnEnter);
		frmFitnessPlanner.setVisible(true);

	}

	private double parseDoubleNumber(String input) {
		// Remove non-numeric characters
		numericPart = input.replaceAll("[^0-9.]", "");
		try {
			return Double.parseDouble(numericPart);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}

	private int parseIntegerNumber(String input) {
		// Remove non-numeric characters
		numericPart = input.replaceAll("[^0-9.]", "");
		try {
			return Integer.parseInt(numericPart);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private String parseString(String input) {
		return input.replaceAll("[0-9]", "");
	}

}
