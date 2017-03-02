import {User} from "../../src/app/models/user";
import { Promise } from 'es6-promise';
import { AuthPage} from '../pages/auth.po';
import { ProfilePage } from '../pages/profile.po';
import { UserFormPage } from '../pages/userform.po';
import { UserListPage } from '../pages/userlist.po';
import { PasswordResetPage } from '../pages/password-reset.po';
import { ClassBookPage } from './../pages/classbook.po';

import presenceOf = protractor.ExpectedConditions.presenceOf;
import {GroupFormPage} from "../pages/groupform.po";
import {NavigationComponent} from "../components/navigation.po";

/**
 * Created by alex on 07/12/16.
 */
const dateNow: number = Date.now();

export const testUser01: User = {
    id: dateNow,
    first_name: `Pro_${dateNow}`,
    last_name: `Tractor_${dateNow}`,
    email: `protractor+${dateNow}@helloclass.ch`
};

// this user is generated on the backend side (test data)
export const teacher01 = {
    firstName: 'Dresl',
    lastName: 'Feuz',
    email: 'feuz@ch.ch',
    username: 'feuz',
    password: 'test'
};

/**
 *
 * Sometimes the protractor is to fast. Even before the next page is rendered.
 * In such case wait for the element and then assert the value. Max wait time is 5 seconds,
 * which should be enough. If not, don't increment the timeout, but analyze and fix the
 * Webapp performance.
 *
 * @param e: the element to check
 * @param expected: the expected text of element
 */
export function waitAssertText(e, expected) {
    browser.wait(presenceOf(e), 5000);
    expect(e.getText()).toMatch(expected);
}

/**
 *
 * Same function as waitAssertText, but unfortunately span element has a different access to Text
 *
 * Sometimes the protractor is to fast. Even before the next page is rendered.
 * In such case wait for the element and then assert the value. Max wait time is 5 seconds,
 * which should be enough. If not, don't increment the timeout, but analyze and fix the
 * Webapp performance.
 *
 * @param e: the element to check
 * @param expected: the expected text of element
 */
export function waitAssertTextSpan(e, expected) {
    browser.wait(presenceOf(e), 5000);
    expect(e.getAttribute('textContent')).toMatch(expected);
}

// creates a new student with the default teacher
let formPage = new UserFormPage();
let pageAuth = new AuthPage();
let userListPage = new UserListPage();
let passwordResetPage = new PasswordResetPage();
let pageNavigation = new NavigationComponent();
let pageGroup = new GroupFormPage();

export function createStudent() {
    let dateNow: number = Date.now();

    let testUser = {
        firstName: `Protractor_Fritz_${dateNow}`,
        lastName: 'Protractor_Radlhofer',
        email: `fritz+${dateNow}@radlhofer.ch`,
        password: 'testme'
    };

    createNewStudent(testUser)
        .then(link => activateUser(testUser, link));

    pageAuth.get();
    pageAuth.username = testUser['email'];
    pageAuth.password = testUser['password'];
    pageAuth.doLogin();
    browser.wait(presenceOf($(ClassBookPage.calendarClassSelector)), 5000);

    return Promise.resolve(testUser);

}

function createNewStudent(testUser) {
    // create a new testuser with a teacher
    pageAuth.doLogout();
    pageAuth.get();
    pageAuth.username = teacher01.email;
    pageAuth.password = teacher01.password;
    pageAuth.doLogin();
    browser.wait(presenceOf($(ClassBookPage.calendarClassSelector)), 5000);

    let groupPosition = 0;

    formPage.get();

    formPage.selectGroupAtPosition(groupPosition);
    formPage.fillInFormForStudent(testUser['firstName'], testUser['lastName'], testUser['email']);
    formPage.submitForm();

    userListPage.clickUserWithName(testUser['firstName'], testUser['lastName']);
    browser.wait(presenceOf($(UserFormPage.firstNameElementSelector)), 5000);

    return formPage.activationLink.getAttribute('value');
}

function activateUser(testUser: Object, activationLink: string) {
    pageAuth.doLogout();
    browser.get(activationLink);
    browser.wait(presenceOf($(PasswordResetPage.inputSelector)), 5000);
    passwordResetPage.password = testUser['password'];
    passwordResetPage.submitForm();
}

export function addGroup(displayName){
    pageNavigation.clickHeaderButton();
    pageNavigation.clickGroupsLink();
    pageNavigation.clickGroupAdd();
    pageGroup.displayName = displayName;
    pageGroup.submitForm();
}

