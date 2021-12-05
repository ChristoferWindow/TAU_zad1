import requests
import inspect
import json
from pygments import console

'''
    https://passwordinator.herokuapp.com/generate?num=true
    ?num=true ( adds number to the password )
    ?char=true (adds special character to the password )
    ?caps=true ( adds uppercase alphabets to the password )
    ?len=14 ( generates a 14 character password )
'''

class ApiTests:
    url = 'https://passwordinator.herokuapp.com/generate'
    header = {'conent-type': 'application/json'}
    request_method = 'GET'

    def __init__(self):
        self.test_returns_password_with_numbers()
        self.test_returns_empty_string_password_when_invalid_len_param_value()
        self.test_returns_password_with_14_characters_length_and_numbers()
        self.test_returns_password_without_numeric_values_when_num_param_is_empty()
        self.test_returns_data_key_with_not_empty_password_string()
        self.test_connects_to_server_and_receives_success_reponse()

    def test_returns_password_with_numbers(self):
        result = json.loads(requests.request(self.request_method, self.url + '?num=true').text)['data']

        assertion = self.make_assertion(any(char.isdigit() for char in result), True)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def test_returns_empty_string_password_when_invalid_len_param_value(self):
        result = json.loads(requests.request(self.request_method, self.url + '?len=invalid').text)['data']

        assertion = self.make_assertion(len(result) > 0, False)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def test_returns_password_with_14_characters_length_and_numbers(self):
        result = json.loads(requests.request(self.request_method, self.url + '?len=14').text)['data']

        assertion = self.make_assertion(len(result) == 14, True)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def test_returns_password_without_numeric_values_when_num_param_is_empty(self):
        result = json.loads(requests.request(self.request_method, self.url + '?num=').text)['data']

        assertion = self.make_assertion(not any(char.isdigit() for char in result), True)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def test_returns_data_key_with_not_empty_password_string(self):
        result = json.loads(requests.request(self.request_method, self.url).text)['data']

        assertion = self.make_assertion(len(result) > 0, True)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def test_connects_to_server_and_receives_success_reponse(self):
        result = requests.request(self.request_method, self.url + '?num=true').status_code

        assertion = self.make_assertion(result, 200)
        test_name = inspect.stack()[0][3]
        self.print_test_result(test_name, assertion)

    def make_assertion(self, given, expected) -> bool:
        try:
            assert given == expected
            return True
        except AssertionError:
            return False
    def print_test_result(self, test_name, is_passed):
        if is_passed:
            print(console.colorize('green', test_name + ': passed'))
        else:
            print(console.colorize('red', test_name + ': failed'))

tests = ApiTests()
