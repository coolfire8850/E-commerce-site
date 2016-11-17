<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<%@ include file="/public/head.jspf"%>
<link rel="stylesheet" href="${shop }/css/jquery-ui.css" />
<link rel="stylesheet" href="${shop }/css/jquery.idealforms.min.css" />
<%-- <link rel="stylesheet" href="${shop }/css/normalize.css" /> --%>

<style type="text/css">
body {
	font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
	color: #222;
	/* background: url(css/images/pattern.png); */
	overflow-y: scroll;
	
}

#my-form {
	
	width: 755px;
	/* margin: 0 auto;
	border: 1px solid #ccc;
	padding: 3em;
	border-radius: 3px;
	box-shadow: 0 0 2px rgba(0, 0, 0, .2); */
}

#comments {
	width: 350px;
	height: 100px;
}
</style>



</head>

<body>

	<div class="wrapper">

		<s:include value="head.jsp" />

		<!-- <div class="row"> -->

			<!-- <div class="eightcol last"> -->

				<!-- Begin Form -->
		<div class="section_container">
				<form id="my-form" action="" method="post">

					<section name="First Step">

					<div>
						<label><s:text name="name"/>:</label><input id="username" name="username"
							type="text" />
					</div>
					<div>
						<label><s:text name="password"/>:</label><input id="pass" name="password" type="password" />
					</div>
					<div>
						<label><s:text name="email"/>:</label><input id="email" name="email"
							data-ideal="required email" type="email" />
					</div>
					<div>
						<label><s:text name="birth"/>:</label><input name="date" class="datepicker"
							data-ideal="date" type="text" placeholder="月/日/年" />
					</div>
					<div>
						<label><s:text name="photo"/>:</label><input id="file" name="file" multiple
							type="file" />
					</div>
					<div>
						<label><s:text name="homepage"/>:</label><input name="website" data-ideal="url"
							type="text" />
					</div>
					</section>

					<section name="Second Step">
					<div id="languages">
						<label><s:text name="language"/>:</label> <label><input type="checkbox"
							name="langs[]" value="English" /><s:text name="english"/></label> <label><input
							type="checkbox" name="langs[]" value="Chinese" /><s:text name="chinese"/></label> <label><input
							type="checkbox" name="langs[]" value="Spanish" /><s:text name="spanish"/></label> <label><input
							type="checkbox" name="langs[]" value="French" /><s:text name="french"/></label>
					</div>
					<div>
						<label><s:text name="proficient"/>:</label> <label><input type="radio"
							name="radio" checked />1</label> <label><input type="radio"
							name="radio" />2</label> <label><input type="radio" name="radio" />3</label>
						<label><input type="radio" name="radio" />4</label>
					</div>
					</section>

					<section name="Third Step">
					<div>
						<label><s:text name="tel"/>:</label><input type="tel" name="phone"
							data-ideal="phone" />
					</div>
					<div>
						<label><s:text name="nation"/>:</label> <select id="states" name="states">
							<option value="default">&ndash; <s:text name="choose"/> &ndash;</option>
							<option value="AL"><s:text name="arabe"/></option>
							<option value="AK"><s:text name="china"/></option>
							<option value="AZ"><s:text name="usa"/></option>
							<option value="AR"><s:text name="france"/></option>
							<option value="CA"><s:text name="england"/></option>
							<option value="CO"><s:text name="german"/></option>
							<option value="CT"><s:text name="espagne"/></option>
							<option value="DE"><s:text name="russia"/></option>
						</select>
					</div>
					<div>
						<label><s:text name="zip"/>:</label><input type="text" name="zip" data-ideal="zip" />
					</div>
					<div>
						<label><s:text name="comment"/>:</label>
						<textarea id="comments" name="comments"></textarea>
					</div>
					</section>

					<div>
						<hr />
					</div>

					<div>
						<button type="submit"><s:text name="submit"/></button>
						<button id="reset" type="button"><s:text name="reset"/></button>
					</div>

				</form>

				<!-- End Form -->

			<!-- </div> -->

		<!-- </div> -->
		</div>
		<s:include value="foot.jsp" />
	</div>
	
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/jquery.idealforms.js"></script>
	<script type="text/javascript">
			function searchProduct() {
		
				window.location.href = "product_search.action?name=" + $("#key").val();
			}
		var options = {

			onFail : function() {
				alert($myform.getInvalid().length + ' invalid fields.')
			},

			inputs : {
				'password' : {
					filters : 'required pass',
				},
				'username' : {
					filters : 'required username',
					data : {
					//ajax: { url:'validate.php' }
					}
				},
				'file' : {
					filters : 'extension',
					data : {
						extension : [ 'jpg' ]
					}
				},
				'comments' : {
					filters : 'min max',
					data : {
						min : 50,
						max : 200
					}
				},
				'states' : {
					filters : 'exclude',
					data : {
						exclude : [ 'default' ]
					},
					errors : {
						exclude : 'choose nationality'
					}
				},
				'langs[]' : {
					filters : 'min max',
					data : {
						min : 2,
						max : 3
					},
					errors : {
						min : 'Check at least <strong>2</strong> options.',
						max : 'No more than <strong>3</strong> options allowed.'
					}
				}
			}

		};

		var $myform = $('#my-form').idealforms(options).data('idealforms');

		$('#reset').click(function() {
			$myform.reset().fresh().focusFirst()
		});

		$myform.focusFirst();
	</script>

</body>
</html>