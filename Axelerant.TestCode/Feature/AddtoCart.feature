#Author: Shubhangi Bheda 


	@tag
	Feature: As a existing user I want to search for a product, add it to cart and proceed to checkout. 
	After completing the checout process validate that order is placed successfully.
  
  @tag1
  	Scenario: Successfully Adding item to cart
    Given User is on Home Page
    When User search for product
    And Click to Add to Cart
    Then Message displayed Product successfully added to your shopping cart and proceed to checkoout
    
   @tag2
   Scenario: Sign In and Place Order
   When Sign In as Existing User enters "shubh_8june@gmail.com" and "shubhangi"
   And Complete Process of checkout
   Then Order is Placed Successfully