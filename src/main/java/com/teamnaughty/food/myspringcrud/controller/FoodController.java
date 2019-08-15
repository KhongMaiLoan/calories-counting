package com.teamnaughty.food.myspringcrud.controller;

import org.springframework.stereotype.Controller;

@Controller
public class FoodController
{
//    @Autowired
//    private FoodService foodService;
//
//    @Autowired
//    private UserServiceImpl userServiceImpl;
//
//
//    private UserSession userSession = new UserSession();
//    public User user = new User();
//
//    @RequestMapping("/search")
//    public String FoodSearch1(Model model){
//        return "index3";
//    }
//
//    @RequestMapping("/{usermail}/search")
//    public String FoodSearch2(@PathVariable("usermail") String usermail, Model model)
//    {
//        userSession.setEmail(usermail);
//        model.addAttribute("userSession", userSession);
//        return "index3_1";
//    }
//
//    @RequestMapping("/infor/{food_name}")
//    public String FoodDetail1(@PathVariable String food_name, Model model)
//    {
//        List<Food> foodList = foodService.findFoodsByName(food_name);
//        model.addAttribute("foodList", foodList);
//        System.out.printf("food received: " + food_name + "\n\n");
//        return "FoodInfor";
//    }
//
//    @RequestMapping("/{usermail}/infor/{food_name}")
//    public String FoodDetail2(@PathVariable("usermail") String usermail, @PathVariable("food_name") String food_name, Model model){
//        List<Food> foodList = foodService.findFoodsByName(food_name);
//        userSession.setEmail(usermail);
//
//        model.addAttribute("foodList", foodList);
//        model.addAttribute("userSession",userSession);
//
//        System.out.printf("food received: " + food_name + "\n\n");
//        return "FoodInfor1";
//    }
//
//    @RequestMapping("/infor/")
//    public String FoodDetail3(){
//        return "index3";
//    }
//
//    @RequestMapping("/{usermail}/infor/")
//    public String FoodDetail4(@PathVariable("usermail") String usermail,  Model model){
//
//        userSession.setEmail(usermail);
//        model.addAttribute("userSession",userSession);
//        return "FoodInfor1";
//    }
//
//    // Calculating user's BMR ( use form to get: age, sex, height, weight, intensity)
//    @GetMapping("/{usermail}/caloriesquantity")
//    public String Caloquantity(@PathVariable("usermail") String usermail ,Model model){
//        user = userServiceImpl.findUserByEmail(usermail);
//
//        if (user == null)
//            return "index3";
//
//        List<Gender> Gender = Arrays.asList(
//                new Gender("nam"),
//                new Gender("nữ")
//        );
//
//        List<TrainingIntensity> trainingIntensities = Arrays.asList(
//                new TrainingIntensity(0,"Ít vận động hoặc không tập thể dục"),
//                new TrainingIntensity(13,"Tập thể dục 1-3 lần/tuần"),
//                new TrainingIntensity(35,"Tập thể dục 3-5 lần/tuần"),
//                new TrainingIntensity(67,"Tập thể dục 6-7 lần/tuần"),
//                new TrainingIntensity(7,"Tập thể dục cường độ cao hơn 7 lần/tuần")
//        );
//
//        model.addAttribute("user",user);
//        model.addAttribute("gender",Gender);
//        model.addAttribute("intensities", trainingIntensities);
//
//        return "CaloriesQuantity";
//    }
//
//    // Notify user's BMR
//    @PostMapping("/{usermail}/user_bmr")
//    public String userBMR(@PathVariable("usermail") String usermail ,@ModelAttribute("user") User user, Model model)
//    {
//        User updateUser = userServiceImpl.findUserByEmail(usermail);
//        updateUser.setAge(user.getAge());
//        updateUser.setWeight(user.getWeight());
//        updateUser.setHeight(user.getHeight());
//        updateUser.setGender(user.getGender());
//        System.out.println("sex: " + updateUser.getGender());
//        updateUser.setTrainingintensity(user.getTrainingintensity());
//
//        System.out.println("training intensity: " + updateUser.getTrainingintensity());
//        userServiceImpl.saveUser(updateUser);
//        System.out.println("Thanh cong luu nhe!");
//
//        model.addAttribute("user",updateUser);
//        return "CaloriesQuantityRes";
//    }
//
//    // Adding foods to user's daily food.
//    @RequestMapping("/{usermail}/calorieslack/{food_name}/{sum_calo}/{sum_dam}/{sum_beo}/{sum_botduong}/{sum_xo}/{selected_food}/{num}")
//    public String AddFood1(@PathVariable("usermail") String usermail,
//                           @PathVariable("food_name") String food_name,
//                           @PathVariable("sum_calo") double sum_calo,
//                           @PathVariable("sum_dam") double sum_dam,
//                           @PathVariable("sum_beo") double sum_beo,
//                           @PathVariable("sum_botduong") double sum_botduong,
//                           @PathVariable("sum_xo") double sum_xo,
//                           @PathVariable("selected_food") String selected_food,
//                           @PathVariable("num") String num,
//                           Model model)
//    {
//        System.out.println("\n\nselected food: " + selected_food +"\n");
//        List<Food> foodList = foodService.findFoodsByName(food_name);
//
//        User user = userServiceImpl.findUserByEmail(usermail);
//
//        user.addSumcalo(new Double(sum_calo ));
//        user.addSumdam(new Double(sum_dam));
//        user.addSumbeo(new Double(sum_beo));
//        user.addSumbotduong(new Double(sum_botduong));
//        user.addSumxo(new Double(sum_xo));
//        user.setSelectfood(food_name);
//
//        if (user.atefood.length()>0)
//            user.atefood = user.atefood + " . " + selected_food + "  :   " + num;
//        else
//            user.atefood = selected_food + "   :  " + num;
//
//        userServiceImpl.saveUser(user);
//        System.out.println("user sum's calories = " + user.getSumcalo());
//
//        model.addAttribute("user", user);
//        model.addAttribute("foodList", foodList);
//        return "CaloriesLack";
//    }
//
//    @RequestMapping("/{usermail}/calorieslack//0/0/0/0/0/ / /")
//    public String AddFood2(@PathVariable("usermail") String usermail,  Model model){
//        User userSession = userServiceImpl.findUserByEmail(usermail);
//        model.addAttribute("userSession",userSession);
//        return "ConsumtionCalories";
//    }
//
//    @RequestMapping("/{usermail}/calorieslack//0/0/0/0/0/ /  /")
//    public String AddFood3(@PathVariable("usermail") String usermail,  Model model){
//        User userSession = userServiceImpl.findUserByEmail(usermail);
//        model.addAttribute("userSession",userSession);
//        return "ConsumtionCalories";
//    }
//
//    @RequestMapping("/{usermail}/calorieslack/refreshfood//0/0/0/0/0/ /  /")
//    public String AddFood4(@PathVariable("usermail") String usermail,  Model model){
//        User userSession = userServiceImpl.findUserByEmail(usermail);
//        userSession.refreshFood();
//        userServiceImpl.saveUser(userSession);
//
//        model.addAttribute("userSession",userSession);
//        return "ConsumtionCalories";
//    }
//
//    @RequestMapping("/{usermail}/consumptioncalories")
//    public String FoodAte(@PathVariable("usermail") String usermail,  Model model)
//    {
//        User userSession = userServiceImpl.findUserByEmail(usermail);
//        model.addAttribute("userSession", userSession);
//
//        // check user infor is completed or not
//        if (userSession.is_infor_completed()){
//            return "ConsumtionCalories";
//        }
//        return "user_infor_require";
//
//    }
//
//    @RequestMapping("/login")
//    public String login(){
//        if (user.getName().equals("anonymous")){
//            return "signUp_signIn";
//        }
//        else {
//            return "signOut" ;
//        }
//    }

}
