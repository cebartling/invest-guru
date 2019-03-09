from invest_guru.handlers.simple_moving_average_analytic_handler import handle

expected_symbol = "MSFT"
event = {"symbol": expected_symbol}


def test__handle__success_verify_result(mocker):
    mocker.patch('invest_guru.handlers.simple_moving_average_analytic_handler.simple_moving_average',
                 side_effect=[{"2019-03-09": "105.6878"}, {"2019-03-09": "106.1234"}])

    result = handle(event, None)

    assert result is not None
    assert "company" in result


def test__handle__success_verify_collaborators(mocker):
    sma_patch = mocker.patch('invest_guru.handlers.simple_moving_average_analytic_handler.simple_moving_average',
                             side_effect=[
                                 [
                                     {"2019-03-09": "105.6878"},
                                     {"2019-03-08": "105.3456"},
                                     {"2019-03-07": "105.1122"},
                                 ],
                                 [
                                     {"2019-03-09": "104.8885"},
                                     {"2019-03-08": "104.6844"},
                                     {"2019-03-07": "104.5561"},
                                 ]
                             ])

    handle(event, None)

    sma_patch.assert_any_call(symbol=expected_symbol, time_period=50)
    sma_patch.assert_any_call(symbol=expected_symbol, time_period=300)
