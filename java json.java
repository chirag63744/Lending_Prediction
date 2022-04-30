 String Gender=(String)jComboBox1.getSelectedItem();
        String Married=(String)jComboBox2.getSelectedItem();
        String Dependents =(String)jComboBox3.getSelectedItem();
        String Education=(String)jComboBox4.getSelectedItem();
        String Self_Employed=(String)jComboBox5.getSelectedItem();
        String ApplicantIncome=(String)jTextField2.getText();
        String coapplicantIncome=(String)jTextField3.getText();
        String LoanAmount=(String)jTextField4.getText();
        String Loan_Amount_Term="360.0";
        String Credit_History=(String)jTextField6.getText();
        String Property_Area=(String)jComboBox2.getSelectedItem();
        String income= jTextField2.getText();
        int i=Integer.parseInt(income);
        //take inputs
        if(Gender.equals("Male"))
        {
            Gender="1";
        }
        else
        {
           Gender="0";
        }
        if(Married.equals("Married"))
        {
            Married="0";
        }
        else
        {
            Married="1";
        }
        if(Dependents.equals("Yes"))
        {
            Dependents="1";
        }
        else
        {
           Dependents="0";
        }
        if(Education.equals("Graduate"))
        {
            Education="0";
        }
        else
        {
            Education="0";
        }
        if( Self_Employed.equals("YES"))
        {
             Self_Employed="1";
        }
        else
        {
             Self_Employed="0";
        }
        if( Property_Area.equals("Rural"))
        {
             Property_Area="0";
        }
        else if(Property_Area.equals("Urban"))
        {
             Property_Area="2";
        }
        else
        {
             Property_Area="1";
        }
        

        String query_url = "http://127.0.0.1:5000/json";
        String json = "{ \"Gender\" : "+Gender+" ,\"Married\" : "+Married+" , \"Dependents\" : "+Dependents+" , \"Education\" : "+Education+" , \"Self_Employed\" : "+Self_Employed+" , \"ApplicantIncome\" : "+ApplicantIncome+" , \"coapplicantIncome\" : "+coapplicantIncome+" , \"LoanAmount\" : "+LoanAmount+" , \"Loan_Amount_Term\" : "+Loan_Amount_Term+" , \"Credit_History\" : "+Credit_History+" , \"Property_Area\" : "+Property_Area+" }";
        //System.out.println(json);
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            //System.out.println(result);
            JSONObject myResponse = new JSONObject(result);
            //JOptionPane.showMessageDialog(this,"cycle lenght "+ myResponse.getInt("pre") + "and estimated "+ myResponse.getInt("pre1"));
            if(myResponse.getInt("pre")==1){
                JOptionPane.showMessageDialog(null,"Loan Granted");
                

            }
            else{
                JOptionPane.showMessageDialog(null,"Loan  will not be Granted");

            }

            //System.out.println("estimated values "+ myResponse.getInt("pre"));

            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }                                        
