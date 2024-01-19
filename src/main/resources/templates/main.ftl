<#import "parts/common.ftl" as c>
<#import "parts/temp.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Input message" />
        <input type="text" name="tag" placeholder="Tag">

        <button type="submit">Add</button>
    </form>
</div>
<div>Messages list</div>
<form method="get", action="/main">
    <input type="text" name="filter" value="${filter}">

    <button type="submit">Search</button>
</form>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>
</div>
<#else>
No message
</#list>
</@c.page>