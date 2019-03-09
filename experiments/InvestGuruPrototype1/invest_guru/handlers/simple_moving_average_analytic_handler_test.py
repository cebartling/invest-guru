from invest_guru.handlers.simple_moving_average_analytic_handler import handle

expected_symbol = "MSFT"
event = {"symbol": expected_symbol}


def test__handle__success_verify_result(mocker):
    mocker.patch('invest_guru.handlers.simple_moving_average_analytic_handler.simple_moving_average',
                 side_effect=[{"2019-03-09": "105.6878"}, {"2019-03-09": "106.1234"}])

    result = handle(event, None)
    print(result)

    assert result is not None
    assert "company" in result


def test__handle__success_verify_collaborators(mocker):
    sma_patch = mocker.patch('invest_guru.handlers.simple_moving_average_analytic_handler.simple_moving_average',
                             side_effect=[{"2019-03-09": "105.6878"}, {"2019-03-09": "106.1234"}])

    handle(event, None)

    sma_patch.assert_any_call(symbol=expected_symbol, time_period=50)
    sma_patch.assert_any_call(symbol=expected_symbol, time_period=300)
