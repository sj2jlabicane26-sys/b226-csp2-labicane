package com.joysistvi.recordingapp.view;

import java.util.Scanner;

public class WelcomeView {

    private final Scanner scanner = new Scanner(System.in);

    private final AdminView adminView;
    private final UserView userView;
    private final AdminDashboard adminDashboard;
    private final UserDashboard userDashboard;

    public WelcomeView(AdminView adminView,
                       UserView userView,
                       AdminDashboard adminDashboard,
                       UserDashboard userDashboard) {

        this.adminView = adminView;
        this.userView = userView;
        this.adminDashboard = adminDashboard;
        this.userDashboard = userDashboard;
    }

    public void showMenu() {

        boolean running = true;



        while(running){



            System.out.println("\n=================================");
            System.out.println("     RECORDING STUDIO SYSTEM");
            System.out.println("=================================");


            System.out.println("1. Create Admin Account");
            System.out.println("2. Admin Login");

            System.out.println("3. Create User Account");
            System.out.println("4. User Login");

            System.out.println("0. Exit");



            System.out.print("Enter Choice: ");



            int choice = scanner.nextInt();
            scanner.nextLine();




            switch(choice){




                // CREATE ADMIN



                case 1:


                    /*
                      Database Flow:

                      AdminView
                          |
                      AdminController
                          |
                      AdminService
                          |
                      AdminRepository
                          |
                      INSERT INTO admins

                    */


                    adminView.createAdmin();


                    break;







                // ADMIN LOGIN



                case 2:



                    if(adminView.login()){


                        System.out.println(
                                "Admin Login Successful!"
                        );


                        adminDashboard.mainMenu();


                    }
                    else{


                        System.out.println(
                                "Invalid Admin Account!"
                        );


                    }


                    break;








                // CREATE USER



                case 3:



                    /*
                      Database Flow:

                      UserView
                          |
                      UserController
                          |
                      UserService
                          |
                      UserRepository
                          |
                      INSERT INTO users

                    */


                    userView.registerUser();


                    break;








                // USER LOGIN



                case 4:



                    userView.loginUser();


                    userDashboard.showMenu();


                    break;









                // EXIT



                case 0:



                    System.out.println(
                            "Thank you for using Recording Studio System!"
                    );


                    running = false;


                    break;






                default:


                    System.out.println(
                            "Invalid Choice!"
                    );



            }



        }



        scanner.close();


    }
}