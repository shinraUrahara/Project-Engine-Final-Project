
import java.util.Scanner;

public class Quantum_Loop {
      static Scanner input =new Scanner(System.in);
    static String[]userNames={"ahmed","omar","malak","hamo"};
    static String[]userIds={"12311","12312","12322","12321"};
    static String[]emails={"ahmed@gmail.com","omar@gmail.com","yahia@gmail.com","hamo@gmail.com"};
    static String []phoneNumbers={"01212345678","01112345678","01012345678","01512345678"};
    static long []balances={7000,5000,850000,6650};
    static boolean[]isBlocked={true,false,true,true,};
    static String[]transactionStatuses={"success","failure","success","failure"};
    static String []passwords={"5666","7800","4555","6543"};
    static int[] transactionIds = {12355,12356,12366,12367};
    static int[] senderIndices = {1,3,0,2};
    static int[] receiverIndices = {2,1,3,0};
    static long[] amounts = {5000,6000,700,2000};
    static int amount=4;
    
    public static void ViewAllTransactions(){
        for(int i=0;i<amount;i++){
            System.out.println("Transaction Id:  "+transactionIds[i]);
            System.out.println("Seander :  "+userNames[senderIndices[i]]);
            System.out.println("Receiver :  "+userNames[receiverIndices[i]]);
            System.out.println("Amount :  "+amounts[i]*100);
            System.out.println("Transaction status : "+transactionStatuses[i]);
            
            
        }
    }
    public static void showStatics(){
        System.out.println("total number of registerd users:"+userNames.length);
        int active=0;
        int blocked=0;
        int successful_transactions=0;
        int failed_transactions=0;
        double successful_transfers=0;
        for (int i=0;i<isBlocked.length;i++){
            //اللوب دي اعرف منها اليوزرز الاكتيف و البلوكد
            if(isBlocked[i]==false){
                active++;
            }else{
                blocked++;
            }
        }
        System.out.println("Number of active users: "+active);
        System.out.println("Number of blocked accounts: "+blocked);
        for(int i=0;i<amount;i++){
            //اللوب دي بتلف ع قد عدد العمليات سواء ناجحه او لا ومنها بعرف عدد ال نجحت و ال فشلت
            if(transactionStatuses[i].equals("success")){
                successful_transactions++;
                successful_transfers+=amounts[i];
            }else{
                failed_transactions++;
            }
        }
        System.out.println("Total number of successful transactions: "+successful_transactions);
        System.out.println("Total number of failed transactions: "+failed_transactions);
        System.out.println("Total  amount of successful transfers: "+successful_transfers);
    }
    public static void searchUser(){
        //الميثود دي هسرش منها عن اليوزرز عن طريق(الاسم،الid،الرقم،الايميل)وهعرف شوية معلومات عامه بس
        System.out.println("How do you want to searche a user?");
        System.out.println("1:id\n2:FullName\n3:PhoneNumber\n4:EmailAddress\n(1 or 2or 3or 4) ?");
        int choose=input.nextInt();
        int index2=-1;
        switch(choose){
            case 1:
            System.out.print("Enter id :");
            String Id=input.next();
            boolean ID=false;
            for(int i=0;i<userIds.length;i++){
                if (userIds[i].equals(Id)){
                    ID=true;
                    index2=i;
                }
            }
            if(ID==true){
                 System.out.println("User name: "+userNames[index2]);
                    System.out.println("User Id: "+userIds[index2]);
                    if(isBlocked[index2]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
            }else{
                System.out.println("not found");
            }
            break;
            case 2:
            System.out.print("Enter Name:");
            boolean NAME=false;
            String name=input.next();
            for(int i=0;i<userIds.length;i++){
                if (userNames[i].equals(name)){
                    NAME=true;
                    index2=i;
                }
            }
            if(NAME==true){
                System.out.println("User name: "+userNames[index2]);
                System.out.println("User Id: "+userIds[index2]);
                if(isBlocked[index2]==true){
                    System.out.println("Status acc: Is Blocked .");
                }else{
                    System.out.println("Status acc: Is Active .");
                }
            }else{
                System.out.println("Not found");
            }
            break;
            case 3:
            System.out.print("Enter Phone number :");
            String phone=input.next();
            boolean PHONE=false;
            for(int i=0;i<userIds.length;i++){
                if (phoneNumbers[i].equals(phone)){
                    PHONE=true;
                    index2=i;
                }
            }
            
            if(PHONE==true){
                System.out.println("User name: "+userNames[index2]);
                System.out.println("User Id: "+userIds[index2]);
                if(isBlocked[index2]==true){
                    System.out.println("Status acc: Is Blocked .");
                }else{
                    System.out.println("Status acc: Is Active .");
                }
            }else{
                System.out.println("Not found");
            }
         break;
        case 4:
            System.out.print("Enter email :");
            String email=input.next();
            boolean EMAIL=false;
            for(int i=0;i<userIds.length;i++){
                if (emails[i].equals(email)){
                    EMAIL=true;
                    index2=i;
                }
            if(EMAIL==true){
                System.out.println("User name: "+userNames[index2]);
                System.out.println("User Id: "+userIds[index2]);
                if(isBlocked[index2]==true){
                    System.out.println("Status acc: Is Blocked .");
                }else{
                    System.out.println("Status acc: Is Active .");
                }
            }else{
                System.out.println("Not found");
            }
            }
            break;
            default :
            System.out.println("wrong choice!");
            break;   
        }
        
    }
    public static void viewUserDetails(){
        //الميثود دي هسرش منها عن اليوزرز عن طريق(الاسم،الid،الرقم،الايميل)وهعرف شوية معلومات عنو
        System.out.println("How do you want to searche a user?");
        System.out.println("1:id\n2:FullName\n3:PhoneNumber\n4:EmailAddress\n(1 or 2or 3or 4) ?");
        int choose=input.nextInt();
        switch(choose){
            case 1:
            System.out.print("Enter id :");
            String Id=input.next();
            boolean ID=false;
            for(int i=0;i<userIds.length;i++){
                if (userIds[i].equals(Id)){
                    ID=true;
                    System.out.println("User name: "+userNames[i]);
                    System.out.println("User Id: "+userIds[i]);
                    System.out.println("Phone: "+phoneNumbers[i]);
                    System.out.println("email: "+emails[i]);
                    if(isBlocked[i]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
                    System.out.println("Balance: "+balances[i]*100);
                }
            }
            if(ID==false){
                System.out.println("Not found");
            }
            break;
            case 2:
            System.out.print("Enter Name:");
            boolean NAME=false;
            String name=input.next();
            for(int i=0;i<userIds.length;i++){
                if (userNames[i].toUpperCase().equals(name.toUpperCase())){
                    NAME=true;
                    System.out.println("User name: "+userNames[i]);
                    System.out.println("User Id: "+userIds[i]);
                    System.out.println("Phone: "+phoneNumbers[i]);
                    System.out.println("email: "+emails[i]);
                    if(isBlocked[i]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
                    System.out.println("Balance: "+balances[i]*100);
                }
            }
            if(NAME==false){
                System.out.println("Not found");
            }
            break;
            case 3:
            System.out.print("Enter Phone number :");
            String phone=input.next();
            boolean PHONE=false;
            for(int i=0;i<userIds.length;i++){
                if (phoneNumbers[i].equals(phone)){
                    PHONE=true;
                    System.out.println("User name: "+userNames[i]);
                    System.out.println("User Id: "+userIds[i]);
                    System.out.println("Phone: "+phoneNumbers[i]);
                    System.out.println("email: "+emails[i]);
                    if(isBlocked[i]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
                    System.out.println("Balance: "+balances[i]*100);
                }
            }
            if(PHONE==false){
                System.out.println("Not found");
            }
         break;
        case 4:
            System.out.print("Enter email :");
            String email=input.next();
            boolean EMAIL=false;
            for(int i=0;i<userIds.length;i++){
                if (emails[i].toUpperCase().equals(email.toUpperCase())){
                    EMAIL=true;
                    System.out.println("User name: "+userNames[i]);
                    System.out.println("User Id: "+userIds[i]);
                    System.out.println("Phone: "+phoneNumbers[i]);
                    System.out.println("email: "+emails[i]);
                    if(isBlocked[i]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
                    System.out.println("Balance: "+balances[i]*100);
                }
            }
            if(EMAIL==false){
                System.out.println("Not found");
            }
            break;
            default:
            System.out.println("wrong choice!");
       
    }
         }
    public static void viewAllUsers(){
        for(int i=0;i<userNames.length;i++){
            System.out.println("User "+(i+1));
            System.out.println("User name="+userNames[i]);
            System.out.println("User Id= "+userIds[i]);
            System.out.println("Email= "+emails[i]);
            System.out.println("Phone= "+phoneNumbers[i]);
            System.out.println("Balance= "+balances[i]*100);
            if(isBlocked[i]==true){
                        System.out.println("Status acc: Is Blocked .");
                    }else{
                        System.out.println("Status acc: Is Active .");
                    }
            
    }
         }
    public static void updateUser(){
          System.out.println("How do you want to searche a user?");
          System.out.println("1:id\n2:FullName\n3:PhoneNumber\n4:EmailAddress\n(1 or 2or 3or 4) ?");
          int index=-1;
          int choose4=input.nextInt();
          switch(choose4){
              case 1:
              boolean ID4;
              do{
                  System.out.print("Enter id :");
                  String Id4=input.next();
                  ID4=false;
                  for(int i=0;i<userNames.length;i++){
                      if(Id4.equals(userIds[i])){
                          ID4=true;
                          index=i;
                      }
                  }
                  if (ID4==true){
                      System.out.println("What do you want to change :") ;
                      System.out.println("1:User name \n2:Email\n3:phone\n(1,2,3)?");
                      int choice4=input.nextInt();
                      boolean isTaken;
                      switch(choice4){
                          case 1:
                          String newName;
                          System.out.println("Old user :"+userNames[index]);
                          System.out.println("Enter a new username :");
                          do{
                              isTaken=false;
                              newName=input.next();
                              for(int i=0;i<userNames.length;i++){
                                  if (i!=index){
                                      if(newName.equals(userNames[i])){
                                          System.out.println("this name is already in use \n please enter another name .");
                                          isTaken=true;
                                          break;
                                      }
                                  }
                              }
                          }while(isTaken);
                          userNames[index]=newName;
                          System.out.println("the new username: "+userNames[index]);
                          break;
                          case 2:
                          String newEmail;
                          System.out.println("old email: "+emails[index]);
                          System.out.println("Enter a new userEmail (it must end with (@gmail.com):");
                          do{
                              isTaken=false;
                              newEmail=input.next();
                              if(newEmail.endsWith("@gmail.com")){
                                  //ممكن ادخل اي حاجه و خلاص ف عشان نحل المشكله دي استخدمنا فانكشن endWith
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newEmail.equals(emails[i])){
                                              System.out.println("this email is already in use \n please enter another email .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userEmail again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          emails[index]=newEmail;
                          System.out.println("the new userEmail: "+emails[index]);
                          break;
                          case 3:
                          String newPhone;
                          System.out.println("the old userNumber: "+phoneNumbers[index]);
                          System.out.println("Enter a new userPhone :\n(it must start with(012,011,010,015)and contain 11 digits ");
                  //بعرفو الشرط عشان مهو ممكن يدخلي اي حاجه وخلاص
                          do{
                              isTaken=false;
                              newPhone=input.next();
                              if(newPhone.matches("01[0125][0-9]{8}")){
                          //01ال ف اللول معناها شرط الرقم يبدا بيهم 
                          // [0125]معناها الرقم التالت شرطو يكون حاجه منهم 
                          //[0-9]معناها ان شرط ال input يكون ارقام بس من0ل9,{8} معناها ان باقي عندك تلت اماكن لاننا ب الفعل حددنا اول تلت ارقام من ال 11
                                  
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newPhone.equals(phoneNumbers[i])){
                                              System.out.println("this userPhone is already in use \n please enter another phone .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userphone again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          phoneNumbers[index]=newPhone;
                          System.out.println("the new userphone: "+phoneNumbers[index]);
                      }
                  }else{
                      System.out.println("Not found\nPlease try again");
                  }
              }while(ID4==false);
              break;
              case 2:
              boolean NAME4=false;
              do{
                  System.out.print("Enter User name :");
                  String name4=input.next();
                  NAME4=false;
                  for(int i=0;i<userNames.length;i++){
                      if(name4.equals(userNames[i])){
                          NAME4=true;
                          index=i;
                      }
                  }
                  if (NAME4==true){
                      System.out.println("What do you want to change :") ;
                      System.out.println("1:User name \n2:Email\n3:phone\n(1,2,3)?");
                      int choice4=input.nextInt();
                      boolean isTaken;
                      switch(choice4){
                          case 1:
                          String newName;
                          System.out.println("Old user :"+userNames[index]);
                          System.out.println("Enter a new username :");
                          do{
                              isTaken=false;
                              newName=input.next();
                              for(int i=0;i<userNames.length;i++){
                                  if (i!=index){
                                      if(newName.equals(userNames[i])){
                                          System.out.println("this name is already in use \n please enter another name .");
                                          isTaken=true;
                                          break;
                                      }
                                  }
                              }
                          }while(isTaken);
                          userNames[index]=newName;
                          System.out.println("the new username: "+userNames[index]);
                          break;
                          case 2:
                          String newEmail;
                          System.out.println("old email: "+emails[index]);
                          System.out.println("Enter a new userEmail (it must end with (@gmail.com):");
                          do{
                              isTaken=false;
                              newEmail=input.next();
                              if(newEmail.endsWith("@gmail.com")){
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newEmail.equals(emails[i])){
                                              System.out.println("this email is already in use \n please enter another email .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userEmail again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          emails[index]=newEmail;
                          System.out.println("the new userEmail: "+emails[index]);
                          break;
                          case 3:
                          String newPhone;
                          System.out.println("the old userNumber: "+phoneNumbers[index]);
                          System.out.println("Enter a new userPhone :\n(it must start with(012,011,010,015)and contain 11 digits ");
                  //بعرفو الشرط عشان مهو ممكن يدخلي اي حاجه وخلاص
                          do{
                              isTaken=false;
                              newPhone=input.next();
                              if(newPhone.matches("01[0125][0-9]{8}")){
                          //01ال ف اللول معناها شرط الرقم يبدا بيهم 
                          // [0125]معناها الرقم التالت شرطو يكون حاجه منهم 
                          //[0-9]معناها ان شرط ال input يكون ارقام بس من0ل9,{8} معناها ان باقي عندك تلت اماكن لاننا ب الفعل حددنا اول تلت ارقام من ال 11
                                  
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newPhone.equals(phoneNumbers[i])){
                                              System.out.println("this userPhone is already in use \n please enter another phone .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userphone again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          phoneNumbers[index]=newPhone;
                          System.out.println("the new userphone: "+phoneNumbers[index]);
                      }
                  }else{
                      System.out.println("Not found\nPlease try again");
                  }
              }while(NAME4==false);
              break;
              case 3:
              boolean PHONE4=false;
              do{
                  System.out.println("Enter userPhone :\n(it must start with(012,011,010,015)and contain 11 digits ");
                  String phone4=input.next();
                  PHONE4=false;
                  if(phone4.matches("01[0125][0-9]{8}")){
                      for(int i=0;i<userNames.length;i++){
                          if(phone4.equals(phoneNumbers[i])){
                              PHONE4=true;
                              index=i;
                          }
                      }
                  }else{
                      System.out.println("please folow the instructions\nenter the userphone again .");
                  }
                  if (PHONE4==true){
                      System.out.println("What do you want to change :") ;
                      System.out.println("1:User name \n2:Email\n3:phone\n(1,2,3)?");
                      int choice4=input.nextInt();
                      boolean isTaken;
                      switch(choice4){
                          case 1:
                          String newName;
                          System.out.println("Old user :"+userNames[index]);
                          System.out.println("Enter a new username :");
                          do{
                              isTaken=false;
                              newName=input.next();
                              for(int i=0;i<userNames.length;i++){
                                  if (i!=index){
                                      if(newName.equals(userNames[i])){
                                          System.out.println("this name is already in use \n please enter another name .");
                                          isTaken=true;
                                          break;
                                      }
                                  }
                              }
                          }while(isTaken);
                          userNames[index]=newName;
                          System.out.println("the new username: "+userNames[index]);
                          break;
                          case 2:
                          String newEmail;
                          System.out.println("old email: "+emails[index]);
                          System.out.println("Enter a new userEmail (it must end with (@gmail.com):");
                          do{
                              isTaken=false;
                              newEmail=input.next();
                              if(newEmail.endsWith("@gmail.com")){
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newEmail.equals(emails[i])){
                                              System.out.println("this email is already in use \n please enter another email .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userEmail again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          emails[index]=newEmail;
                          System.out.println("the new userEmail: "+emails[index]);
                          break;
                          case 3:
                          String newPhone;
                          System.out.println("the old userNumber: "+phoneNumbers[index]);
                          System.out.println("Enter a new userPhone :\n(it must start with(012,011,010,015)and contain 11 digits ");
                  //بعرفو الشرط عشان مهو ممكن يدخلي اي حاجه وخلاص
                          do{
                              isTaken=false;
                              newPhone=input.next();
                              if(newPhone.matches("01[0125][0-9]{8}")){
                          //01ال ف اللول معناها شرط الرقم يبدا بيهم 
                          // [0125]معناها الرقم التالت شرطو يكون حاجه منهم 
                          //[0-9]معناها ان شرط ال input يكون ارقام بس من0ل9,{8} معناها ان باقي عندك تلت اماكن لاننا ب الفعل حددنا اول تلت ارقام من ال 11
                                  
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newPhone.equals(phoneNumbers[i])){
                                              System.out.println("this userPhone is already in use \n please enter another phone .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userphone again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          phoneNumbers[index]=newPhone;
                          System.out.println("the new userphone: "+phoneNumbers[index]);
                      }
                  }else{
                      System.out.println("Not found\nPlease try again");
                  }
              }while(PHONE4==false);
              
              break;
              case 4:
              boolean EMAIL4=false;
              String email4;
              do{
                  System.out.println("Enter a userEmail :\n(it must end with (@gmail.com) )");
                  email4=input.next();
                  EMAIL4=false;
                  if(email4.endsWith("@gmail.com")){
                      for(int i=0;i<userNames.length;i++){
                          if(email4.equals(emails[i])){
                              EMAIL4=true;
                              index=i;
                          }
                      }
                  }
                  if (EMAIL4==true){
                      System.out.println("What do you want to change :") ;
                      System.out.println("1:User name \n2:Email\n3:phone\n(1,2,3)?");
                      int choice4=input.nextInt();
                      boolean isTaken;
                      switch(choice4){
                          case 1:
                          String newName;
                          System.out.println("Old user :"+userNames[index]);
                          System.out.println("Enter a new username :");
                          do{
                              isTaken=false;
                              newName=input.next();
                              for(int i=0;i<userNames.length;i++){
                                  if (i!=index){
                                      if(newName.equals(userNames[i])){
                                          System.out.println("this name is already in use \n please enter another name .");
                                          isTaken=true;
                                          break;
                                      }
                                  }
                              }
                          }while(isTaken);
                          userNames[index]=newName;
                          System.out.println("the new username: "+userNames[index]);
                          break;
                          case 2:
                          String newEmail;
                          System.out.println("old email: "+emails[index]);
                          System.out.println("Enter a new userEmail (it must end with (@gmail.com):");
                          do{
                              isTaken=false;
                              newEmail=input.next();
                              if(newEmail.endsWith("@gmail.com")){
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newEmail.equals(emails[i])){
                                              System.out.println("this email is already in use \n please enter another email .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userEmail again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          emails[index]=newEmail;
                          System.out.println("the new userEmail: "+emails[index]);
                          break;
                          case 3:
                          String newPhone;
                          System.out.println("the old userNumber: "+phoneNumbers[index]);
                          System.out.println("Enter a new userPhone :\n(it must start with(012,011,010,015)and contain 11 digits ");
                  //بعرفو الشرط عشان مهو ممكن يدخلي اي حاجه وخلاص
                          do{
                              isTaken=false;
                              newPhone=input.next();
                              if(newPhone.matches("01[0125][0-9]{8}")){
                          //01ال ف اللول معناها شرط الرقم يبدا بيهم 
                          // [0125]معناها الرقم التالت شرطو يكون حاجه منهم 
                          //[0-9]معناها ان شرط ال input يكون ارقام بس من0ل9,{8} معناها ان باقي عندك تلت اماكن لاننا ب الفعل حددنا اول تلت ارقام من ال 11
                                  
                                  for(int i=0;i<userNames.length;i++){
                                      if (i!=index){
                                          if(newPhone.equals(phoneNumbers[i])){
                                              System.out.println("this userPhone is already in use \n please enter another phone .");
                                              isTaken=true;
                                              break;
                                          }
                                      }
                                  }
                              }else{
                                  System.out.println("please folow the instructions\nenter the userphone again .");
                                  isTaken=true;
                              }
                          }while(isTaken);
                          phoneNumbers[index]=newPhone;
                          System.out.println("the new userphone: "+phoneNumbers[index]);
                      }
                  }else{
                      System.out.println("Not found\nPlease try again");
                  }
              }while(EMAIL4==false);
              break;
              default:
              System.out.println("wrong choice!");
          }
      }
    public static void blockAccount(){
        System.out.println("Enter userId you want to block: ");
        boolean ID5;
        int index5=-1;
        String IdBlock;
        do{
            ID5=false;
            IdBlock=input.next();
            for(int i=0;i<userIds.length;i++){
                if(userIds[i].equals(IdBlock)){
                    ID5=true;
                    index5=i;
                }
            }
            if(ID5==true){
                if (isBlocked[index5]==true){
                    System.out.println("the user was allready blocked");
                }else{
                    isBlocked[index5]=true;
                    System.out.println("he is blocked now");
                }
            }else{
                System.out.println("Not found. ");
                System.out.println("Enter userId you want to block: ");
            }
        }while(ID5==false);
    }
    public static void unblockAccount(){
        System.out.println("Enter userId you want to unblock: ");
        boolean ID6;
        int index6=-1;
        String IdUnBlock;
        do{
            ID6=false;
            IdUnBlock=input.next();
            for(int i=0;i<userIds.length;i++){
                if(userIds[i].equals(IdUnBlock)){
                    ID6=true;
                    index6=i;
                }
            }
            if(ID6==true){
                if (isBlocked[index6]==true){
                    System.out.println("the user is unBlocked now");
                    isBlocked[index6]=false;
                }else{
                    System.out.println("the user was allready unBlocked");
                }
            }else{
                System.out.println("Not found. ");
                System.out.println("Enter userId you want to block: ");
            }
        }while(ID6==false);
        
    }

    public static void main(String[] args) {
        boolean choiceAdmin=false;
        do{
            System.out.println("========== ADMIN PANEL ==========");
            System.out.println("1.Show Statics\n2. Search User\n3. View All Usees\n4. Update User\n5. View All Transactions\n6. Block Account\n7. Unblock Account\n8.View User Ditails\n9. Logout");
            System.out.println("Choose an option : (1,2,3,4,5,6,7,8,9)");
            int choiceAdmin1=input.nextInt();
            switch(choiceAdmin1){
                case 1:
                showStatics();
                break;
                case 2:
                searchUser();
                break;
                case 3:
                viewAllUsers();
                break;
                case 4:
                updateUser();
                case 5:
                ViewAllTransactions();
                break;
                case 6:
                blockAccount();
                break;
                case 7:
                unblockAccount();
                break;
                case 8:
                viewUserDetails();
                break;
                case 9:
                System.out.println("^ Good bye ^");
                break;
                default :
                System.out.println("Wrong choice ");
                continue;
            }
            System.out.println("Do you want to return to the main menu\n1. yes\n2. no");
            int choiceAdmin2=input.nextInt();
            
            if(choiceAdmin2==1){
                choiceAdmin=true;
            }else if(choiceAdmin2==2){
                choiceAdmin=false;
                System.out.println("^Good Bye^");
                
            }else {
                System.out.println("Wrong choice");
            }
        }while(choiceAdmin==true)  ; 
            
        
        
        
        
    }
    
}