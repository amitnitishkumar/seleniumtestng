package com.example.assignment.locatorepos;

import org.openqa.selenium.By;

public interface McPizzaAgentLocators {
    By CHATAGENTBTN = By.cssSelector("img[role='button']");
    By GETSTARTEDBTN = By.cssSelector("a.get-started-link");
    By FIRSTNAMEINPUT = By.cssSelector("#first_name");
    By EMAILINPUT = By.cssSelector("#email");
    By NEXTBTN = By.cssSelector(".send.btn");

    String FRAMENAME = "avaamoIframe";

    By QUERYTEXTAREA = By.cssSelector("#queryTextbox");
    By BOTRESPONSE = By.cssSelector(".conversation-item.clearfix.not-mine");
    By SENDQUERYLABEL = By.cssSelector("[aria-label='Send']");
    By TRIPLEDOT = By.cssSelector(".la-ball-pulse.la-sm");
    By SELECTBOTOPTIONS = By.xpath("//a[text()='%s']");
    By TOPPINGCHKBOX = By.xpath("//span[text()='%s']/preceding-sibling::span");
    By SUBMITBTN = By.xpath("//button[@aria-label='%s' and not(@data-dismiss)]");
    By CRUSTLABEL = By.xpath("//div[@class='default_card_title' and text()='%s']/following-sibling::div/a[text()='Thick Crust']");
    By FEEDBACKICON = By.cssSelector(".%s.locale-trans");
//    .thumbs-up.locale-trans
    By PICKCOMBOBOX = By.cssSelector("input[role='combobox']");
    By COMBOXOPTION = By.xpath("//li[text()='%s']");
    By FEEDBACKSUMITIONMSG = By.xpath("//div[text()='%s']");
}
