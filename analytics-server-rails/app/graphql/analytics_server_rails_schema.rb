class AnalyticsServerRailsSchema < GraphQL::Schema
  use GraphQL::Execution::Interpreter
  # To skip preprocessing (you can use the interpreter without adding this)
  use GraphQL::Analysis::AST

  mutation(Types::MutationType)
  query(Types::QueryType)
end
