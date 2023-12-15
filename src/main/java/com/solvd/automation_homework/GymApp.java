package com.solvd.automation_homework;

import com.solvd.enums.Month;
import com.solvd.enums.MusclePrimaryFunction;
import com.solvd.enums.PaymentMethod;
import com.solvd.enums.RPE;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class GymApp {
    private static final int gymAppVersion;
    private static final Logger LOGGER;


    static {
        gymAppVersion = 2;
        System.setProperty("log4j.configurationFile","log4j2.xml");
        LOGGER = Logger.getLogger("GymApp.class");
    }

    public static void main(String[] args){
        Equipment powerBar = new Equipment(1,"Powerlifting Bar","Generic","Bar",20,"Steel");
        Equipment ezBar = new Equipment(2,"EZ Curl Bar","Generic","Bar",10,"Steel");
        Equipment hackSquat = new Equipment(3,"Hack Squat Machine","Generic","Machine",40,"Steel");

        Muscle quads = new Muscle(1,"Quadriceps",MusclePrimaryFunction.EXTENSOR,true);
        Muscle pecs = new Muscle(2,"Pectorals", MusclePrimaryFunction.ADDUCTOR,true);
        Muscle traps = new Muscle(3,"Trapezius",MusclePrimaryFunction.STABILIZER,true);
        Muscle hams = new Muscle(4,"Hamstrings",MusclePrimaryFunction.FLEXOR,true);
        Muscle triceps = new Muscle(5,"Triceps",MusclePrimaryFunction.EXTENSOR,false);
        Muscle biceps = new Muscle(6,"Biceps",MusclePrimaryFunction.FLEXOR,false);
        Muscle glutes = new Muscle(7,"Gluteus",MusclePrimaryFunction.EXTENSOR,true);

        ArrayList<Muscle> squatMuscles = new ArrayList<>();
        squatMuscles.add(quads);
        squatMuscles.add(hams);
        squatMuscles.add(glutes);
        ArrayList<Muscle> benchMuscles = new ArrayList<>();
        benchMuscles.add(pecs);
        benchMuscles.add(triceps);
        ArrayList<Muscle> deadliftMuscles = new ArrayList<>();
        deadliftMuscles.add(traps);
        deadliftMuscles.add(hams);
        deadliftMuscles.add(glutes);
        ArrayList<Equipment> powerEquipment = new ArrayList<>();
        powerEquipment.add(powerBar);
        powerBar.setAvailable(false);

        Exercise squat = new Exercise("Squat","Strength exercise in which the trainee lowers their hips from a standing position and then stands back up",squatMuscles,powerEquipment);
        Exercise bench = new Exercise("Bench Press","Strength exercise in which the trainee lays down on a bench and lowers the bar down to chest level and then press it upwards while extending his arms",benchMuscles,powerEquipment);
        Exercise deadlift = new Exercise("Deadlift","Strength exercise in which the trainee lifts the bar from a resting position on the floor to an upright position",deadliftMuscles,powerEquipment);

        List<Exercise> powerlifting101 = new ArrayList<>();
        powerlifting101.add(squat);
        powerlifting101.add(bench);
        powerlifting101.add(deadlift);

        Instructor instructor = new Instructor(1,"John",new Date(1678882400000L),"john@gmail.com","powerlifting",true,powerlifting101);
        Membership standardMembership = new Membership("Standard",100,10,true,"Cash only");
        Member member = new Member(1,"Mike",new Date(1673462400000L),"mike@gmail.com","General Health",standardMembership);
        Workout powerliftingWorkout = new Workout(1,"Powerlifting 101",powerlifting101,4,instructor,"SBD");
        Session mikePowerSession = new Session(new Date(1673462400000L),member,powerliftingWorkout);

        ArrayList<Person> powerliftingSeminarAttendees = new ArrayList<>();
        powerliftingSeminarAttendees.add(member);
        powerliftingSeminarAttendees.add(instructor);
        Seminar powerliftingSeminar = new Seminar(1,"Powerlifting 101",new Date(1687132800000L),120,instructor,powerliftingSeminarAttendees,"Introductory class to powerlifting",100);


        try{
            mikePowerSession = member.completeSession(powerliftingWorkout, RPE.RPE_10.getValue());
        } catch (InvalidIntensityException e) {
            logExceptionToFile(e);
        }

        try (FileWriter fw = new FileWriter("src/main/java/com/solvd/automation_homework/logs/payments.log",true)){
            fw.write(member.makePayment(80,Month.DECEMBER.getDisplayName(), PaymentMethod.CASH).toString()+System.getProperty("line.separator"));
        } catch (InsufficientMoneyException e){
            logExceptionToFile(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        WorkoutSet firstSet = new WorkoutSet(squat.getName(), squat.getDescription(), squat.getMusclesWorked(),squat.getEquipmentRequired(),10,100,7);
        WorkoutSet secondSet = new WorkoutSet(squat.getName(), squat.getDescription(), squat.getMusclesWorked(),squat.getEquipmentRequired(),6,140,10);
        Predicate<List<Muscle>> hasMajor = (muscles) -> {
            boolean major = false;
            for (Muscle m : muscles)
                if(!major)
                    major = m.isMajorMuscle();
            return major;
        };
        LOGGER.info("Are major muscle groups involved in the "
                +firstSet.getName()+"? "
                +hasMajor.test(firstSet.getMusclesWorked()));

        Function<WorkoutSet,Double> calculateStressIndex = s ->
                s.getVolume() * s.getRpe() / 1000;
        LOGGER.info("Stress index of "
                +secondSet.getName()+": "
                +calculateStressIndex.apply(secondSet));

        Consumer<Seminar> sendReminder = seminar ->
            seminar.getAttendees().forEach(person ->
                    LOGGER.info("Send reminder to: "
                            +person.getContactInfo()));
        sendReminder.accept(powerliftingSeminar);

        Supplier<Exercise> randomExercise = () -> {
            Random random = new Random();
            int randomIndex = random.nextInt(powerlifting101.size());
            return powerlifting101.get(randomIndex);
        };
        LOGGER.info("Get random exercise: "
                +randomExercise.get().getName());

        Runnable seminarAttendeesSayHi = () ->
                powerliftingSeminarAttendees.forEach(Person::introduceMyself);
        seminarAttendeesSayHi.run();

        List<Equipment> gymEquipment = new ArrayList<>();
        gymEquipment.add(powerBar);
        gymEquipment.add(ezBar);
        gymEquipment.add(hackSquat);
        findAvailable(gymEquipment,Equipment::isAvailable)
                .forEach(equipment ->
                        LOGGER.info("Available: "+equipment.getName()));
        List<Instructor> auxList = new ArrayList<>();
        auxList.add(instructor);
        findAvailable(auxList,Instructor::isCertified)
                .forEach(ins ->
                        LOGGER.info("Certified: "+ins.getName()));


        Rateable<Exercise> exerciseAssessment = exercise -> {
            if(hasMajor.test(exercise.getMusclesWorked()))
                return 7;
            else
                return 5;
        };
        LOGGER.info("Rating of the exercise: "
                +exerciseAssessment.rate(squat));
        Rateable<WorkoutSet> setAssessment = workSet -> {
            double baseRating = exerciseAssessment.rate(workSet);
            if(workSet.getRpe()<=7)
                return baseRating;
            else
                return baseRating+2;
        };
        LOGGER.info("Rating of the set: "
                +setAssessment.rate(secondSet));

        IPickWinner<Person> contest = contestants ->
                contestants.get(new Random().nextInt(contestants.size()));
        LOGGER.info("And the winner is: "
                +contest.pickWinner(powerliftingSeminarAttendees).getName()
                +"!");


        List<Exercise> auxWorkoutSets = new ArrayList<>();
        auxWorkoutSets.add(firstSet);
        auxWorkoutSets.add(secondSet);
        mikePowerSession.getWorkout().setExercises(auxWorkoutSets);
        LOGGER.info("Volume calculated with aggregates: "
                +firstSet.getVolume()+" + "
                +secondSet.getVolume()+" = "
                +mikePowerSession.getVolume());

        OptionalDouble average = auxWorkoutSets.stream()
                .filter(WorkoutSet.class::isInstance)
                .map(WorkoutSet.class::cast)
                .mapToDouble(WorkoutSet::getVolume)
                .average();
        if(average.isPresent()) LOGGER.info("Volume average is: "+average.getAsDouble());

        List<Muscle> bicepsCurlMuscles = new ArrayList<>();
        bicepsCurlMuscles.add(biceps);
        List<Equipment> bicepsCurlEquipment = new ArrayList<>();
        bicepsCurlEquipment.add(ezBar);
        Exercise bicepsCurl = null;
        try {
            bicepsCurl = instructor.createExercise("Biceps Curl","Curl Description",bicepsCurlMuscles,bicepsCurlEquipment);
            LOGGER.info("Exercise "+bicepsCurl.getName()+" created successfully.");
        } catch (MissingEquipmentException e) {
            logExceptionToFile(e);
        }

        List<Equipment> availableEquipment = gymEquipment.stream()
                .filter(Equipment::isAvailable)
                .collect(Collectors.toList());
        availableEquipment.forEach(equipment ->
                LOGGER.info("Available: "+equipment.getName()));

        powerlifting101.add(bicepsCurl);
        mikePowerSession.getWorkout().setExercises(powerlifting101);
        powerliftingWorkout.getExercises().stream()
                .filter(exercise ->
                    exercise.getMusclesWorked().stream()
                            .anyMatch(Muscle::isMajorMuscle)
                ).collect(Collectors.toList())
                .forEach(e ->
                LOGGER.info("Exercise with major muscle groups: "+e.getName()));

        squatMuscles.stream().filter(muscle ->
                muscle.getPrimaryFunction() == MusclePrimaryFunction.FLEXOR)
                .collect(Collectors.toList())
                .forEach(flexor ->
                        LOGGER.info("Flexors in the Squat: "+flexor.getName()));

        powerliftingSeminar.getAttendees().stream()
                .filter(Instructor.class::isInstance)
                .map(Instructor.class::cast)
                .filter(Instructor::isCertified)
                .forEach(instr ->
                        LOGGER.info("Certified instructor assisting the seminar: "
                        +instr.getName()));

        String eqClassName = "com.solvd.automation_homework.Equipment";
        try {
            Class refClass = Class.forName(eqClassName);
            Field[] declaredFields = refClass.getDeclaredFields();
            Arrays.stream(declaredFields)
                    .forEach(field ->
                            LOGGER.info("Field: "
                                    +Modifier.toString(field.getModifiers())
                                    +" "+field.getType().getName()
                                    +" "+field.getName()));
            Constructor[] constructors = refClass.getConstructors();
            Arrays.stream(constructors)
                    .forEach(constructor ->
                            LOGGER.info("Constructor: "
                                    +Modifier.toString(constructor.getModifiers())
                                    +" "+Arrays.toString(constructor.getParameters())));
            Method[] methods = refClass.getDeclaredMethods();
            Arrays.stream(methods).forEach(method ->
                    LOGGER.info(Modifier.toString(method.getModifiers())
                            +" "+method.getReturnType()
                            +" "+method.getName()
                            +" "+Arrays.toString(method.getParameters())));
            Equipment refEq = (Equipment) constructors[0].newInstance(99,"Magic Machine","Generic","Machine",999,"Blue");
            LOGGER.info("Created with reflection: "
                    +refEq.getName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printSummary(Equipment eq, Exercise ex, Instructor in, Member me, Membership ms, Muscle mu, Payment pa, Seminar se, Session ss, Workout wo){
        System.out.println(
                "In summary: "+me.getName()+" paid his "+ms.getType()
                +" Membership on "+pa.getDate()
                +" and completed "+wo.getName()+" from instructor "
                +in.getName()+" on the "+ss.getDate()
                +". He did "+ex.getName()+"s with the "+eq.getName()
                +" which primarily work the "+mu.getName()
                +", and his perceived effort for the session was "+ss.getSessionRPE()
                +". He will be attending the "+se.getName()
                +" seminar on the"+se.getDate());
    }

    public static int getGymAppVersion() {
        return gymAppVersion;
    }

    public static void logExceptionToFile(Exception exception) {
        Logger logger = Logger.getLogger("ExceptionLogger");

        try (CustomFileHandler fileHandler = new CustomFileHandler("src/main/java/com/solvd/automation_homework/logs/exceptions.log", true)) {
            logger.addHandler(fileHandler.getFileHandler());

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("Exception occurred: " + exception.getMessage());
        }
        catch (IOException e) {
            LOGGER.info(e.toString());
        }
    }

    public static <T> List<T> findAvailable(List<T> inputList, Predicate<T> predicate) {
        List<T> outputList = new ArrayList<>();
        for (T element : inputList) {
            if (predicate.test(element)) {
                outputList.add(element);
            }
        }
        return outputList;
    }


}
