Feature: Smoke test scenarios

@smoke
Scenario: a new customer should see the email address or mobile phone number prompt after clicking buy now on a product
Given Launch website 																		
When search for kindle reader																								
And Click buy now																				                                               
Then Verify email address prompt is displayed																								
