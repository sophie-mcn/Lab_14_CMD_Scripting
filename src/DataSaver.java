import static java.nio.file.StandardOpenOption.CREATE;

void main(String[] args) {
    ArrayList <String>recs = new ArrayList<>();
    Scanner in =  new Scanner(System.in);
    boolean done = false;

    while(!done){
        String fName = SafeInput.getNonZeroLenString(in, "Enter your first name");
        String lName = SafeInput.getNonZeroLenString(in, "Enter your last name");
        String IDNum = SafeInput.getRegExString(in, "Enter your ID number", "^\\d{6}$");
        String email = SafeInput.getRegExString(in, "Enter your email address", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
        String yob = SafeInput.getRegExString(in, "Enter your year of birth", "^\\d{4}$");
        String csv = fName + ", " + lName + ", " + IDNum + ", " + email + ", " + yob;
        recs.add(csv);

        done = SafeInput.getYNConfirm(in, "Are you finished with your inputs?");
    }


    String loc = SafeInput.getNonZeroLenString(in, "Enter your file name");
    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + loc + ".csv");

    try
    {
        OutputStream out =
            new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));

        for(String rec : recs)
        {
            writer.write(rec, 0, rec.length());
            writer.newLine();
        }
        writer.close();
        System.out.println("Data file written.");
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }

}
