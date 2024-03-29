package com.automation.core.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * <pre>
 * <b>
 * <a href="https://www.youtube.com/channel/UC6PTXUHb6j4Oxf0ccdRI11A">Testing Mini Bytes Youtube channel</a>
 * </b>
 * </pre>
 * 
 * Jan 21, 2021 
 * @author Amuthan Sakthivel
 * @version 1.0
 * @since 1.0
 * @see com.tmb.factories.ExplicitWaitFactory
 * @see com.tmb.pages.BasePage
 */
public enum WaitStrategy {
	
	
	CLICKABLE,
	PRESENCE,
	VISIBLE,
	NONE

}
